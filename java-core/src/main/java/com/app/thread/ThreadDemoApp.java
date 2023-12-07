package com.app.thread;

public class ThreadDemoApp {
    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        ThreadExample thread1 = new ThreadExample();
        thread1.setName("First TH");
        thread1.start();

        ThreadExample thread2 = new ThreadExample();
        thread2.setName("Second TH");
        thread2.start();

        Thread th = new Thread(new RunnableExample());
        th.setName("Third TH");
        th.start();
    }
}
