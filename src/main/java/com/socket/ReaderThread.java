package com.socket;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderThread implements  Runnable{
    private ObjectInputStream inputStream;
    private String name;
    Thread thread;
    public ReaderThread(ObjectInputStream inputStream, String name) {
        this.inputStream = inputStream;
        this.name = name;
        Runnable target;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // read from server
       while (true){
           try {
               var massager = (String) inputStream.readObject();
               System.out.println(name+ "-- massage received  = " + massager);
           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
           }
       }

    }

    public String getName() {
        return name;
    }
}
