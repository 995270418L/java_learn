package com.steve.designModule.BuildModule;

import com.steve.designModule.BuildModule.Abstractes.VideoPlay;
import com.steve.designModule.BuildModule.Classes.Actor;
import com.steve.designModule.BuildModule.Classes.ActorController;
import com.steve.designModule.BuildModule.Classes.MiniModule;

/**
 * Created by liu on 3/27/17.
 */
public class Main {

    public static void main(String... args){
        //完全模式
        VideoPlay vp = new MiniModule();
        ActorController ac = new ActorController();
        Actor actor = ac.construct(vp);
        System.out.println(actor.getMainContainer());
        System.out.println(actor.getControllerBar());
        System.out.println(actor.getPlayList());
    }
}
