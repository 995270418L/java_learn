package com.steve.designModule.BuildModule.Classes;

import com.steve.designModule.BuildModule.Abstractes.VideoPlay;

/**
 * Created by liu on 3/27/17.
 */
public class MiniModule extends VideoPlay {

    @Override
    public void buildMenuAppear() {
        actor.setMenuAppear("显示菜单");
    }

    @Override
    public void buildPlayList() {
        actor.setPlayList("播放列表");
    }

    @Override
    public void buildMainContainer() {
        actor.setMainContainer("主窗口");
    }

    @Override
    public void buildControllerBar() {
        actor.setControllerBar("控制条");
    }

    @Override
    public void buildCollectList() {
        actor.setCollectList("收藏列表");
    }

    @Override
    public boolean isMiniModule(){
        return true;
    }
}
