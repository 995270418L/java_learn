package com.steve.designModule.PrototypeModule.Classes;

import com.steve.designModule.PrototypeModule.Interfaces.OfficeDocument;

/**
 * Created by liu on 3/26/17.
 */
public class FAR implements OfficeDocument, Cloneable{

    @Override
    public OfficeDocument clone() {
        FAR obj = null;
        try{
            obj = (FAR)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void display() {
        System.out.println("《可行性分析文档》");
    }
}
