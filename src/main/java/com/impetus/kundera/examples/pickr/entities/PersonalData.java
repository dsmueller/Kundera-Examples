/*
 * Copyright 2011 Impetus Infotech.
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
package com.impetus.kundera.examples.pickr.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Class for holding personal data
 * @author amresh.singh
 */

@Embeddable
public class PersonalData
{
    @Column(name="p_name")
    private String name;
    
    @Column(name="p_email")
    private String email;
    
    @Column(name="p_address")
    private String address;
    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }   

}
