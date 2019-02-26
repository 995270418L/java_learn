package com.steve.designModule.PrototypeModule.Interfaces;

import java.io.Serializable;

/**
 * Created by liu on 3/26/17.
 */
public interface OfficeDocument extends Serializable {

    //一个是clone方法
    OfficeDocument clone();
    //一个是display方法,表示他们是哪种officeDocument
    void display();

}
