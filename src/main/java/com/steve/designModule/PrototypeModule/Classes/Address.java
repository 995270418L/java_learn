package com.steve.designModule.PrototypeModule.Classes;

import java.io.Serializable;

/**
 * Created by liu on 3/26/17.
 */
public class Address implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_code() {
        return email_code;
    }

    public void setEmail_code(String email_code) {
        this.email_code = email_code;
    }

    private String email_code;

}
