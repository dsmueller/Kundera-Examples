/**
 * 
 */
package com.impetus.kundera.examples.crud.datatypes;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.impetus.kundera.examples.crud.datatype.entities.StudentEntityDef;
import com.impetus.kundera.examples.crud.datatype.entities.StudentRdbms;

/**
 * The Class StudentDaoTest.
 *
 * @author Vivek Mishra
 */
public class StudentRdbmsTest extends StudentBase<StudentRdbms>
{
    String persistenceUnit = "picmysql";
    
    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception
    {
        setupInternal(persistenceUnit);
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception
    {
        teardownInternal(persistenceUnit);
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void executeTests() {
       onInsert();
       onMerge();
    }

    /**
     * Test method for.
     *
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     * {@link com.impetus.kundera.examples.student.StudentDao#saveStudent(com.impetus.kundera.examples.crud.datatype.entities.StudentRdbms)}
     * .
     */
   
    public void onInsert() 
    {
        try
        {
            onInsert(new StudentRdbms());
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

        // find by id.
        StudentEntityDef s = em.find(StudentRdbms.class, studentId1);
        assertOnDataTypes((StudentRdbms) s);

        // // find by name.
        assertFindByName(em, "StudentRdbms", StudentRdbms.class, "Amresh","STUDENT_NAME");

        // find by name and age.
        assertFindByNameAndAge(em, "StudentRdbms", StudentRdbms.class, "Amresh", "10","STUDENT_NAME");

        // find by name, age clause
        assertFindByNameAndAgeGTAndLT(em, "StudentRdbms", StudentRdbms.class, "Amresh", "10", "20","STUDENT_NAME");
        //
        // // find by between clause
        assertFindByNameAndAgeBetween(em, "StudentRdbms", StudentRdbms.class, "Amresh", "10", "15","STUDENT_NAME");

        // find by Range.
        assertFindByRange(em, "StudentRdbms", StudentRdbms.class, "12345677", "12345678","STUDENT_ID");

        // find by without where clause.
        assertFindWithoutWhereClause(em, "StudentRdbms", StudentRdbms.class);
    }

    /**
     * On merge.
     */
    public void onMerge()
    {
        em.persist(prepareData((Long) studentId1, 78575785897L, "Amresh", true, 10, 'C', (byte) 5, (short) 8,
                (float) 69.6, 163.76765654, enrolmentDate, enrolmentTime, joiningDateAndTime, new Integer(3), new Long(
                        978423946455l), 135434.89, newSqlDate, sqlTime, sqlTimestamp, bigDecimal, bigInteger, calendar,
                new StudentRdbms()));
        StudentRdbms s = em.find(StudentRdbms.class, studentId1);
        Assert.assertNotNull(s);
        Assert.assertEquals("Amresh", s.getStudentName());
        // modify record.
        s.setStudentName("NewAmresh");
        em.merge(s);
        // emf.close();
        //assertOnMerge(em, "StudentRdbms", StudentRdbms.class, "Amresh", "NewAmresh","STUDENT_NAME");
    }

    @Override
    void startServer()
    {
    }

    @Override
    void stopServer()
    {
    }

    @Override
    void createSchema()
    {
    }

    @Override
    void deleteSchema()
    {
    }  
    
}