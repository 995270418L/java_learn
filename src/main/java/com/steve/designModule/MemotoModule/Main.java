package com.steve.designModule.MemotoModule;


import com.steve.designModule.MemotoModule.Classes.ChessMan;
import com.steve.designModule.MemotoModule.Classes.MemotoCaretaker;

/**
 * Created by liu on 4/6/17.
 * 备忘录模式(中国象棋)
 */
public class Main {

    public static void main(String... args){
        MemotoCaretaker mc = new MemotoCaretaker();
        ChessMan chessMan = new ChessMan("车",1,1);
        display(chessMan);
        mc.setChessMemeto(chessMan.save());
        chessMan.setY(4);
        display(chessMan);
        mc.setChessMemeto(chessMan.save());
        chessMan.setX(5);
        display(chessMan);
        System.out.println("****************悔棋****************");
        chessMan.restore(mc.getChessMemeto());
        display(chessMan);
        mc.setChessMemeto(chessMan.save());
    }

    public static void display(ChessMan chessMan){
        System.out.println(chessMan.getLabel() + " X localtion: " + chessMan.getX() + " Y location: " + chessMan.getY());
    }

}
