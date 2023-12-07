package com.app.thread;

public class ThreadExample extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (i < 100){
            System.out.println(i + " " + this.getName());
            i++;
        }
    }
}
