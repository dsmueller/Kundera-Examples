/**
 * Copyright 2012 Impetus Infotech.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.impetus.kundera.examples.crossdatastore.pickr.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity class representing a photographer
 * 
 * @author amresh.singh
 */

@Entity
@Table(name = "PHOTOGRAPHER", schema = "Pickr@piccandra")
public class PhotographerUni_1_1_1_M
{
    @Id
    @Column(name = "PHOTOGRAPHER_ID")
    private int photographerId;
    
    @Column(name = "PHOTOGRAPHER_NAME")
    private String photographerName;

    // Will be persisted locally
    @Embedded
    private PersonalData personalData;

    // One to many, will be persisted separately
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="ALBUM_ID")
    private AlbumUni_1_1_1_M album;     

    /**
     * @return the photographerName
     */
    public String getPhotographerName()
    {
        return photographerName;
    }

    /**
     * @param photographerName the photographerName to set
     */
    public void setPhotographerName(String photographerName)
    {
        this.photographerName = photographerName;
    }

    /**
     * @return the personalData
     */
    public PersonalData getPersonalData()
    {
        return personalData;
    }

    /**
     * @param personalData
     *            the personalData to set
     */
    public void setPersonalData(PersonalData personalData)
    {
        this.personalData = personalData;
    }

    /**
     * @return the photographerId
     */
    public int getPhotographerId()
    {
        return photographerId;
    }

    /**
     * @param photographerId the photographerId to set
     */
    public void setPhotographerId(int photographerId)
    {
        this.photographerId = photographerId;
    }

    public AlbumUni_1_1_1_M getAlbum()
    {
        return album;
    }

    public void setAlbum(AlbumUni_1_1_1_M album)
    {
        this.album = album;
    }   

}