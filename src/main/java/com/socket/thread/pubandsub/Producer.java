package com.socket.thread.pubandsub;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    Thread thread;
    private String name;
    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue,String name) {
        this.queue = queue;
        thread = new Thread(this, name);
        this.name = name;
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(name + "started...........");
       int i =0;
       while (true){

           try {
               if (queue.size() >= 5){
                   System.out.println(name+" Queue is full........");
                   Thread.sleep(2000);
               }
               queue.put(" created cake "+i);
               System.out.println(name+ "Created cake "+(i+1));
               i++;
               Thread.sleep(300);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
