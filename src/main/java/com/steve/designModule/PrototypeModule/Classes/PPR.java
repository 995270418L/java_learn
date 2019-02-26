package com.steve.designModule.PrototypeModule.Classes;

import com.steve.designModule.PrototypeModule.Interfaces.OfficeDocument;

/**
 * Created by liu on 3/26/17.
 */
public class PPR implements OfficeDocument, Cloneable{
    @Override
    public OfficeDocument clone() {
        PPR obj = null;
        try{
            obj = (PPR) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void display() {
        System.out.println("《项目进展报告书》");
    }
}
