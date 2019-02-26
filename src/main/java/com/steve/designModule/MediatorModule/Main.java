package com.steve.designModule.MediatorModule;

import com.steve.designModule.MediatorModule.Abstracts.Components;
import com.steve.designModule.MediatorModule.Classes.*;


/**
 * Created by liu on 4/6/17.
 *
 * 中介者模式　文本框的显示
 */
public class Main {

    public static void main(String... args){

        SubConcreteMediator mediator;
        mediator = new SubConcreteMediator();
        Components c1,c2,c3,c4,c5;
        c1 = new Button();
        c2 = new List();
        c3 = new ComboBox();
        c4 = new TextBox();
        c5 = new Label();
        c1.setMediator(mediator);
        c2.setMediator(mediator);
        c3.setMediator(mediator);
        c4.setMediator(mediator);
        mediator.list = (List) c2;
        mediator.cb = (ComboBox) c3;
        mediator.button = (Button) c1;
        mediator.tb = (TextBox) c4;
        mediator.label = (Label) c5;

        c1.change();
        System.out.println(" ------------------------------- ");
        c2.change();
    }

}
