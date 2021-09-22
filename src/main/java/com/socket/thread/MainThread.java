package com.socket.thread;

public class MainThread {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("current Thread = " + thread);
        thread.setName("Main Thread");
        System.out.println("thread after rename  = " + thread);
        for (int n = 10; n > 0; n--) {
            System.out.println(n);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
