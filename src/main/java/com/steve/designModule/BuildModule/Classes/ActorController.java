package com.steve.designModule.BuildModule.Classes;

import com.steve.designModule.BuildModule.Abstractes.VideoPlay;

/**
 * Created by liu on 3/27/17.
 * 控制建造类
 */
public class ActorController {

    /**
     * 通过这个方法将原材料(vp)建造成一个产品(actor)
     * @param vp
     * @return
     */
    public Actor construct(VideoPlay vp){
        Actor result = vp.createActor();
        vp.buildMainContainer();
        vp.buildControllerBar();
        if(vp.isCompleteModule()){
            vp.buildMenuAppear();
            vp.buildPlayList();
        }
        if(vp.isMemoryModule()){
            vp.buildCollectList();
        }
        return result;

    }
}
