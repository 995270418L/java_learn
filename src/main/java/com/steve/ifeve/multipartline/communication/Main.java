package com.steve.ifeve.multipartline.communication;

/**
 * @Author: steve
 * @Date: Created in 16:57 2018/2/23
 * @Description:
 * @Modified By:
 */
public class Main {

    static class Producer implements Runnable{

        private Middleware middleware;

        public Producer(Middleware middleware){
            this.middleware = middleware;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                    middleware.set();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Customer implements Runnable {

        private Middleware middleware;

        public Customer(Middleware middleware){
            this.middleware = middleware;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                    middleware.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Middleware middleware = new Middleware();
        Producer producer = new Producer(middleware);
        Customer customer = new Customer(middleware);
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(customer).start();
        new Thread(customer).start();
        new Thread(customer).start();
        new Thread(customer).start();
    }
}
