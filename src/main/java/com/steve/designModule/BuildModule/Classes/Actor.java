package com.steve.designModule.BuildModule.Classes;

/**
 * Created by liu on 3/27/17.
 */
public class Actor {

    //显示菜单
    private String menuAppear;

    //播放列表
    public String playList;

    //主窗口
    public String mainContainer;

    //控制条
    public String controllerBar;

    //收藏列表
    public String collectList;

    public String getMenuAppear() {
        return menuAppear;
    }

    public void setMenuAppear(String menuAppear) {
        this.menuAppear = menuAppear;
    }

    public String getPlayList() {
        return playList;
    }

    public void setPlayList(String playList) {
        this.playList = playList;
    }

    public String getMainContainer() {
        return mainContainer;
    }

    public void setMainContainer(String mainContainer) {
        this.mainContainer = mainContainer;
    }

    public String getControllerBar() {
        return controllerBar;
    }

    public void setControllerBar(String controllerBar) {
        this.controllerBar = controllerBar;
    }

    public String getCollectList() {
        return collectList;
    }

    public void setCollectList(String collectList) {
        this.collectList = collectList;
    }
}
