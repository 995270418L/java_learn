package com.steve.jvm.executor;

/**
 * 仅以此例表明 字段没有 多态属性
 */
public class FiledNoPolicy {

    public static void main(String[] args) {
        Father son = new Son();
        System.out.println("This guy has $" + son.money);
    }

    static abstract class Father {
        public int money = 1;

        public Father() {
            this.money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I'm the Father, i have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            this.money = 4;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I'm the Son, i have $" + money);
        }
    }
}