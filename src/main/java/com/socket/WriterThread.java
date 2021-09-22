package com.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WriterThread implements Runnable{
    private ObjectOutputStream objectOutputStream;
    private String name;
    Thread thread;

    public WriterThread(ObjectOutputStream objectOutputStream, String name) {
        this.objectOutputStream = objectOutputStream;
        this.name = name;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
       while (true){
           String massage = scanner.nextLine();
           if (massage.equals("exit")){
               break;
           }
           //  sent to server
           try {
               objectOutputStream.writeObject(massage);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
}
