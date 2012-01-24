package com.impetus.kundera.examples.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="STUDENT", schema="KunderaExamples@addhbase")
public class Student
{
    //Primitive Types
    @Id   
    @Column(name="STUDENT_ID")    
    private String studentId;
    
    @Column(name="UNIQUE_ID")
    private long uniqueId;
    
    @Column(name="STUDENT_NAME")
    private String studentName;
    
    @Column(name="IS_EXCEPTIONAL")
    private boolean isExceptional;
    
    @Column(name="AGE")
    private int age;   
    
    @Column(name="SEMESTER")
    private char semester;      //A,B,C,D,E,F for i to vi
    
    @Column(name="DIGITAL_SIGNATURE")
    private byte digitalSignature;
    
    @Column(name="CGPA")
    private short cgpa;   //1-10
    
    @Column(name="PERCENTAGE")
    private float percentage;
    
    @Column(name="HEIGHT")
    private double height;
    
    //Date-time types
    @Column(name="ENROLMENT_DATE")
    @Temporal(TemporalType.DATE)    
    private java.util.Date enrolmentDate; 
    
    @Column(name="ENROLMENT_TIME")
    @Temporal(TemporalType.TIME)  
    private java.util.Date enrolmentTime;
    
    @Column(name="JOINING_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)  
    private java.util.Date joiningDateAndTime;
    
    //Wrapper types    
    
    
    @Column(name="YEARS_SPENT")
    private Integer yearsSpent;
    
    @Column(name="ROLL_NUMBER")
    private Long rollNumber;
    
    @Column(name="MONTHLY_FEE")
    private Double monthlyFee;    
    
    
    /**
     * @return the studentId
     */
    public long getStudentId()
    {
        return Long.parseLong(studentId);
    }

    /**
     * @param studentId
     *            the studentId to set
     */
    public void setStudentId(long studentId)
    {
        this.studentId = studentId+"";
    }

	/**
     * @return the uniqueId
     */
    public long getUniqueId()
    {
        return uniqueId;
    }

    /**
     * @param uniqueId the uniqueId to set
     */
    public void setUniqueId(long uniqueId)
    {
        this.uniqueId = uniqueId;
    }

    /**
     * @return the studentName
     */
    public String getStudentName()
    {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    /**
     * @return the isExceptional
     */
    public boolean isExceptional()
    {
        return isExceptional;
    }

    /**
     * @param isExceptional the isExceptional to set
     */
    public void setExceptional(boolean isExceptional)
    {
        this.isExceptional = isExceptional;
    }

    /**
     * @return the age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * @return the semester
     */
    public char getSemester()
    {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(char semester)
    {
        this.semester = semester;
    }
    
    /**
     * @return the digitalSignature
     */
    public byte getDigitalSignature()
    {
        return digitalSignature;
    }

    /**
     * @param digitalSignature the digitalSignature to set
     */
    public void setDigitalSignature(byte digitalSignature)
    {
        this.digitalSignature = digitalSignature;
    }

    /**
     * @return the cgpa
     */
    public short getCgpa()
    {
        return cgpa;
    }

    /**
     * @param cgpa the cgpa to set
     */
    public void setCgpa(short cgpa)
    {
        this.cgpa = cgpa;
    }

    /**
     * @return the percentage
     */
    public float getPercentage()
    {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(float percentage)
    {
        this.percentage = percentage;
    }

    /**
     * @return the height
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height)
    {
        this.height = height;
    }

    /**
     * @return the enrolmentDate
     */
    public java.util.Date getEnrolmentDate()
    {
        return enrolmentDate;
    }

    /**
     * @param enrolmentDate the enrolmentDate to set
     */
    public void setEnrolmentDate(java.util.Date enrolmentDate)
    {
        this.enrolmentDate = enrolmentDate;
    }

    /**
     * @return the enrolmentTime
     */
    public java.util.Date getEnrolmentTime()
    {
        return enrolmentTime;
    }

    /**
     * @param enrolmentTime the enrolmentTime to set
     */
    public void setEnrolmentTime(java.util.Date enrolmentTime)
    {
        this.enrolmentTime = enrolmentTime;
    }

    /**
     * @return the joiningDateAndTime
     */
    public java.util.Date getJoiningDateAndTime()
    {
        return joiningDateAndTime;
    }

    /**
     * @param joiningDateAndTime the joiningDateAndTime to set
     */
    public void setJoiningDateAndTime(java.util.Date joiningDateAndTime)
    {
        this.joiningDateAndTime = joiningDateAndTime;
    }

    /**
     * @return the yearsSpent
     */
    public Integer getYearsSpent()
    {
        return yearsSpent;
    }

    /**
     * @param yearsSpent the yearsSpent to set
     */
    public void setYearsSpent(Integer yearsSpent)
    {
        this.yearsSpent = yearsSpent;
    }

    /**
     * @return the rollNumber
     */
    public Long getRollNumber()
    {
        return rollNumber;
    }

    /**
     * @param rollNumber the rollNumber to set
     */
    public void setRollNumber(Long rollNumber)
    {
        this.rollNumber = rollNumber;
    }

    /**
     * @return the monthlyFee
     */
    public Double getMonthlyFee()
    {
        return monthlyFee;
    }

    /**
     * @param monthlyFee the monthlyFee to set
     */
    public void setMonthlyFee(Double monthlyFee)
    {
        this.monthlyFee = monthlyFee;
    }   

}
