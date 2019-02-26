package com.steve.designModule.VisitorModule.Abstracts;


import com.steve.designModule.VisitorModule.Interfaces.Visitor;

/**
 * Created by liu on 4/8/17.
 * 元素类(职工)
 */
public abstract class Employees {

    public abstract void accept(Visitor vistor);

}
