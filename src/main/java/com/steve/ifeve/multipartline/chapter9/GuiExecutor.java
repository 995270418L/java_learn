package com.steve.ifeve.multipartline.chapter9;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by liu on 5/25/17.
 *  GuiExecutor将任务委托给SwingUtilities来执行。
 */
public class GuiExecutor extends AbstractExecutorService {

    private static final GuiExecutor instance = new GuiExecutor();

    private GuiExecutor(){}

    public static GuiExecutor instance(){
        return instance;
    }

    //在执行任务的过程中通过SwingUtilities工具类来实现
    @Override
    public void execute(Runnable command) {
        if(SwingUtilities.isEventDispatchThread()){
            command.run();
        }else{
            SwingUtilities.invokeLater(command);
        }
    }

    @Override
    public void shutdown() {
    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

}
