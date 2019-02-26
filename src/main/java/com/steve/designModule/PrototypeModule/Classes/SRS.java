package com.steve.designModule.PrototypeModule.Classes;

import com.steve.designModule.PrototypeModule.Interfaces.OfficeDocument;

/**
 * Created by liu on 3/26/17.
 */
public class SRS implements OfficeDocument, Cloneable{
    @Override
    public OfficeDocument clone() {
        SRS obj = null;
        try{
            obj = (SRS) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void display() {
        System.out.println("《软件需求说明书》");
    }
}
