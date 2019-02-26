package com.steve.designModule.TemplateMethodModule.Abstracts;

/**
 * Created by liu on 4/8/17.
 * 视图显示器
 */
public abstract class DataViewer {

    public abstract void getData();   //获取数据

    public void convertToXML(){
        System.out.println("将数据转换为xml格式数据");
    }

    //hook method ,判断是否为xml方法
    public boolean isNotXmlData(){
        return true;
    }

    //以某种图标的方式显示xml数据
    public abstract void display();

    //模板方法
    public void process(){
        getData();
        if(isNotXmlData()){
            convertToXML();
        }
        display();
        System.out.println("----------------------------------------");
    }
}
