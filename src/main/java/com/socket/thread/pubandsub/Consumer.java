package com.socket.thread.pubandsub;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<String> blockingQueue;
    Thread thread;
    String name;

    public Consumer(BlockingQueue<String> blockingQueue, String name) {
        this.blockingQueue = blockingQueue;
        this.name = name;
        this.thread = new Thread(this,name);
        thread.start();
    }

    @Override
    public void run() {
      int i =0 ;
      while (true){
          System.out.println(name + "started...........");
          try {
              if (blockingQueue.isEmpty()){
                  System.out.println(name+": queue is empty......");
                  Thread.sleep(2000);
              }
              System.out.println(name+ "got "+blockingQueue.take());
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }
}
