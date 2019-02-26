package com.steve.designModule.TemplateMethodModule;


import com.steve.designModule.TemplateMethodModule.Abstracts.DataViewer;
import com.steve.designModule.TemplateMethodModule.Classes.JsonDataViewer;
import com.steve.designModule.TemplateMethodModule.Classes.XMLDataViewer;

/**
 * Created by liu on 4/8/17.
 * 模板方法(偏向流程控制语句)
 * 某软件公司欲为销售管理系统提供一个数据图表显示功能,该功能的实现包括如下几个步
 * 骤:
 * (1)	从数据源获取数据;
 * (2)	将数据转换为XML格式;
 * (3)	以某种图表方式显示XML格式的数据。
 */
public class Main {

    public static void main(String... args){
        DataViewer d1,d2;
        d1 = new XMLDataViewer();
        d2 = new JsonDataViewer();
        d1.process();
        d2.process();
    }
}
