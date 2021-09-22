package com.socket.thread;

import java.util.concurrent.CopyOnWriteArrayList;

class NewThread implements Runnable {
    Thread thread;
    int threadId;
    NewThread(int threadId) {
        this.threadId = threadId;
        thread = new Thread(this, "Runnable Threads- "+threadId);
        thread.start();
    }

    @Override
    public   void  run() {
        for (int n = 0; n< 5; n++) {
            System.out.println( threadId+ "- Child Thread : " + n);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exit from child Thread "+ threadId);
      }

}

public class RunnableThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start " + Thread.currentThread());
        NewThread newThread1 = new NewThread(1);
        NewThread newThread2 = new NewThread(2);
        System.out.println("newThread1.thread.isAlive() = " + newThread1.thread.isAlive());
        System.out.println("newThread1.thread.isAlive() = " + newThread2.thread.isAlive());

        newThread1.thread.join();
        newThread2.thread.join();

        System.out.println("newThread1.thread.isAlive() = " + newThread1.thread.isAlive());
        System.out.println("newThread1.thread.isAlive() = " + newThread2.thread.isAlive());
        System.out.println("End " + Thread.currentThread());
    }
}
