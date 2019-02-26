package com.steve.designModule.TemplateMethodModule.Classes;

import com.steve.designModule.TemplateMethodModule.Abstracts.DataViewer;

/**
 * Created by liu on 4/8/17.
 */
public class JsonDataViewer extends DataViewer {

    @Override
    public void getData() {
        System.out.println("从数据库获取json数据");
    }

    @Override
    public void display() {
        System.out.println("以柱状图的形式显示xml数据");
    }
}
