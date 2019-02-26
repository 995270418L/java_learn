package com.steve.designModule.BuildModule.Abstractes;

import com.steve.designModule.BuildModule.Classes.Actor;

/**
 * Created by liu on 3/27/17.
 * videoPlay 视频播放类
 */
public abstract class VideoPlay {

    protected Actor actor = new Actor();

    //显示菜单
    public abstract void buildMenuAppear();

    //播放列表
    public abstract void buildPlayList();

    //主窗口
    public abstract void buildMainContainer();

    //控制条
    public abstract void buildControllerBar();

    //收藏列表
    public abstract void buildCollectList();

    public Actor createActor(){
        return actor;
    }

    //hook method
    public boolean isMiniModule(){
        return false;
    }

    public boolean isMemoryModule(){
        return false;
    }

    public boolean isCompleteModule(){
        return false;
    }
}
