package com.steve.ifeve.multipartline.chapter6;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liu on 5/13/17.
 */
public class OutOfTime {

    public static void main(String... args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(),1);  //delay时间单位: 秒
        Thread.sleep(1000);  //到这里程序就结束了，因为会中断timer的下一步操作
        timer.schedule(new ThrowTask(),5);
        Thread.sleep(5000);
    }

    //抛出错误异常
    static class ThrowTask extends TimerTask {

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
