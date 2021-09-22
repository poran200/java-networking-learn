package com.socket.chatapp;

import java.util.Scanner;

public class Writer implements Runnable{
    private NetworkConnection networkConnection;

    public Writer(NetworkConnection networkConnection) {
        this.networkConnection = networkConnection;
    }

    @Override
    public void run() {
        Data data = new Data();
        while (true){
            Scanner scanner = new Scanner(System.in);
            data.setMessage(scanner.nextLine());
            try {
                networkConnection.write(data.clone());
            } catch (CloneNotSupportedException e) {
                System.out.println("Sending failed....");
            }
        }
    }
}
