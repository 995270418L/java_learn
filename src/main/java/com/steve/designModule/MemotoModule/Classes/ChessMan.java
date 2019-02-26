package com.steve.designModule.MemotoModule.Classes;

/**
 * Created by liu on 4/6/17.
 * 原发器类
 */
public class ChessMan {

    private String label;  //棋子
    private int x;  //x 坐标
    private int y;    //y 坐标

    //备忘录类
    private ChessMemeto chessMemeto;

    public ChessMan(String label,int x,int y){
        this.label = label;
        this.x = x;
        this.y = y;
    }

    //保存
    public ChessMemeto save(){
        return new ChessMemeto(this.label,this.x,this.y);
    }

    //恢复
    public void restore(ChessMemeto chessMemeto){
        this.label = chessMemeto.getLabel();
        this.x = chessMemeto.getX();
        this.y = chessMemeto.getY();
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
