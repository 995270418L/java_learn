package com.steve.jvm.executor;

/**
 * 单分派（动态分配）与多分派（静态分配）
 */
public class Dispatch {

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }

    static class QQ {
    }

    static class _360 {
    }

    static class Father {

        public void hardChoice(QQ args) {
            System.out.println("father choose QQ");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }

    }

    static class Son extends Father {
        public void hardChoice(QQ args) {
            System.out.println("son choose QQ");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

}
