/*******************************************************************************
 * * Copyright 2012 Impetus Infotech.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 ******************************************************************************/
package com.impetus.kundera.examples.crossdatastore.pickr;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.impetus.kundera.examples.crossdatastore.pickr.entities.album.AlbumUni_1_M_M_M;
import com.impetus.kundera.examples.crossdatastore.pickr.entities.photo.PhotoUni_1_M_M_M;
import com.impetus.kundera.examples.crossdatastore.pickr.entities.photographer.PhotographerUni_1_M_M_M;

/**
 * @author amresh.singh
 * 
 */
public class PickrTestUni_1_M_M_M extends PickrBaseTest
{

    @Before
    public void setUp() throws Exception
    {
        super.setUp();
    }

    /**
     * Tear down.
     * 
     * @throws Exception
     *             the exception
     */
    @After
    public void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Test.
     */
    @Test
    public void test()
    {
        executeTests();
    }

    @Override
    public void addPhotographer()
    {
        PhotographerUni_1_M_M_M p = preparePhotographer();
        pickr.addPhotographer(p);
    }   

    @Override
    public void getPhotographer()
    {
        PhotographerUni_1_M_M_M p = (PhotographerUni_1_M_M_M) pickr.getPhotographer(PhotographerUni_1_M_M_M.class, ""
                + photographerId);
        assertPhotographer(p);
    }
    
    @Override
    public void updatePhotographer()
    {
        PhotographerUni_1_M_M_M p = (PhotographerUni_1_M_M_M) pickr.getPhotographer(PhotographerUni_1_M_M_M.class, ""
                + photographerId);
        assertPhotographer(p);

        p.setPhotographerName("Vivek");

        pickr.mergePhotographer(p);

        PhotographerUni_1_M_M_M p2 = (PhotographerUni_1_M_M_M) pickr.getPhotographer(PhotographerUni_1_M_M_M.class, ""
                + photographerId);
        assertModifiedPhotographer(p2);
    }

    @Override
    public void getAllPhotographers()
    {
        List<Object> ps = pickr.getAllPhotographers(PhotographerUni_1_M_M_M.class.getSimpleName());
        PhotographerUni_1_M_M_M p = (PhotographerUni_1_M_M_M) ps.get(0);

        assertModifiedPhotographer(p);

    }

    @Override
    public void deletePhotographer()
    {
        PhotographerUni_1_M_M_M p = (PhotographerUni_1_M_M_M) pickr.getPhotographer(PhotographerUni_1_M_M_M.class, ""
                + photographerId);
        assertModifiedPhotographer(p);
        pickr.deletePhotographer(p);
        PhotographerUni_1_M_M_M p2 = (PhotographerUni_1_M_M_M) pickr.getPhotographer(PhotographerUni_1_M_M_M.class, ""
                + photographerId);
        Assert.assertNull(p2);

    }

    private PhotographerUni_1_M_M_M preparePhotographer()
    {
        PhotographerUni_1_M_M_M p = new PhotographerUni_1_M_M_M();
        p.setPhotographerId(photographerId);
        p.setPhotographerName("Amresh");
        
        AlbumUni_1_M_M_M album1 = new AlbumUni_1_M_M_M("album_1", "My Phuket Vacation", "Went Phuket with friends");
        AlbumUni_1_M_M_M album2 = new AlbumUni_1_M_M_M("album_2", "Office Pics", "Annual office party photos");

        PhotoUni_1_M_M_M photo1 = new PhotoUni_1_M_M_M("photo_1", "One beach", "On beach with friends");
        PhotoUni_1_M_M_M photo2 = new PhotoUni_1_M_M_M("photo_2", "In Hotel", "Chilling out in room");
        PhotoUni_1_M_M_M photo3 = new PhotoUni_1_M_M_M("photo_3", "At Airport", "So tired");
        PhotoUni_1_M_M_M photo4 = new PhotoUni_1_M_M_M("photo_4", "Office Team event", "Shot at Fun park");
        PhotoUni_1_M_M_M photo5 = new PhotoUni_1_M_M_M("photo_5", "My Team", "My team is the best");
        
        album1.addPhoto(photo1);
        album1.addPhoto(photo2);
        album1.addPhoto(photo3);
        album1.addPhoto(photo4);
        
        album2.addPhoto(photo2);
        album2.addPhoto(photo3);
        album2.addPhoto(photo4);
        album2.addPhoto(photo5);
        
        p.addAlbum(album1);
        p.addAlbum(album2);
        
        return p;

    }

    private void assertPhotographer(PhotographerUni_1_M_M_M p)
    {
        Assert.assertNotNull(p);
        Assert.assertEquals(1, p.getPhotographerId());
        Assert.assertEquals("Amresh", p.getPhotographerName());
        
        Assert.assertNotNull(p.getAlbums());
        Assert.assertFalse(p.getAlbums().isEmpty());
        Assert.assertEquals(2, p.getAlbums().size());

        AlbumUni_1_M_M_M album1 = p.getAlbums().get(0);
        Assert.assertNotNull(album1);
        Assert.assertTrue(album1.getAlbumId().equals("album_1") || album1.getAlbumId().equals("album_2"));

        Assert.assertFalse(album1.getAlbumName().length() == 0);
        Assert.assertFalse(album1.getAlbumDescription().length() == 0);

        List<PhotoUni_1_M_M_M> album1Photos = album1.getPhotos();
        Assert.assertNotNull(album1Photos);
        Assert.assertFalse(album1Photos.isEmpty());
        Assert.assertTrue(album1Photos.size() == 4);

        PhotoUni_1_M_M_M album1Photo1 = album1Photos.get(0);
        Assert.assertNotNull(album1Photo1);
        Assert.assertEquals(7, album1Photo1.getPhotoId().length());

        AlbumUni_1_M_M_M album2 = p.getAlbums().get(1);
        Assert.assertNotNull(album2);
        Assert.assertTrue(album2.getAlbumId().equals("album_1") || album2.getAlbumId().equals("album_2"));

        Assert.assertFalse(album2.getAlbumName().length() == 0);
        Assert.assertFalse(album2.getAlbumDescription().length() == 0);

        List<PhotoUni_1_M_M_M> album2Photos = album2.getPhotos();
        Assert.assertNotNull(album2Photos);
        Assert.assertFalse(album2Photos.isEmpty());
        Assert.assertTrue(album2Photos.size() == 4);

        PhotoUni_1_M_M_M album2Photo1 = album2Photos.get(0);
        Assert.assertNotNull(album2Photo1);
        Assert.assertEquals(7, album2Photo1.getPhotoId().length());
    }
    
    private void assertModifiedPhotographer(PhotographerUni_1_M_M_M p)
    {
        Assert.assertNotNull(p);
        Assert.assertEquals(1, p.getPhotographerId());
        Assert.assertEquals("Vivek", p.getPhotographerName());
        
        Assert.assertNotNull(p.getAlbums());
        Assert.assertFalse(p.getAlbums().isEmpty());
        Assert.assertEquals(2, p.getAlbums().size());

        AlbumUni_1_M_M_M album1 = p.getAlbums().get(0);
        Assert.assertNotNull(album1);
        Assert.assertTrue(album1.getAlbumId().equals("album_1") || album1.getAlbumId().equals("album_2"));

        Assert.assertFalse(album1.getAlbumName().length() == 0);
        Assert.assertFalse(album1.getAlbumDescription().length() == 0);

        List<PhotoUni_1_M_M_M> album1Photos = album1.getPhotos();
        Assert.assertNotNull(album1Photos);
        Assert.assertFalse(album1Photos.isEmpty());
        Assert.assertTrue(album1Photos.size() == 4);

        PhotoUni_1_M_M_M album1Photo1 = album1Photos.get(0);
        Assert.assertNotNull(album1Photo1);
        Assert.assertEquals(7, album1Photo1.getPhotoId().length());

        AlbumUni_1_M_M_M album2 = p.getAlbums().get(1);
        Assert.assertNotNull(album2);
        Assert.assertTrue(album2.getAlbumId().equals("album_1") || album2.getAlbumId().equals("album_2"));

        Assert.assertFalse(album2.getAlbumName().length() == 0);
        Assert.assertFalse(album2.getAlbumDescription().length() == 0);

        List<PhotoUni_1_M_M_M> album2Photos = album2.getPhotos();
        Assert.assertNotNull(album2Photos);
        Assert.assertFalse(album2Photos.isEmpty());
        Assert.assertTrue(album2Photos.size() == 4);

        PhotoUni_1_M_M_M album2Photo1 = album2Photos.get(0);
        Assert.assertNotNull(album2Photo1);
        Assert.assertEquals(7, album2Photo1.getPhotoId().length());
    }

}
