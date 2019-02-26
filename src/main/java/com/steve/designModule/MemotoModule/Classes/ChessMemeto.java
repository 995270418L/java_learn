package com.steve.designModule.MemotoModule.Classes;

/**
 * Created by liu on 4/6/17.
 * 象棋备忘录类
 */
class ChessMemeto {

    private String label;
    private int x;
    private int y;

    public  ChessMemeto(String label, int x,int y){
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
