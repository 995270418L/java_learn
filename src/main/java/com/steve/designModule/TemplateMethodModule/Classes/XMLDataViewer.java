package com.steve.designModule.TemplateMethodModule.Classes;

import com.steve.designModule.TemplateMethodModule.Abstracts.DataViewer;

/**
 * Created by liu on 4/8/17.
 * xml数据显示
 */
public class XMLDataViewer extends DataViewer {

    @Override
    public void getData() {
        System.out.println("获取xml格式数据");
    }

    @Override
    public void display() {
        System.out.println("以柱状图的形式显示xml格式数据");
    }

    @Override
    public boolean isNotXmlData() {
        return false;
    }
}
