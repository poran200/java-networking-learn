package com.socket.chatapp;

import java.util.Objects;

public class Reader implements Runnable{
    private NetworkConnection networkConnection;
    private String massage = "";

    public Reader(NetworkConnection networkConnection) {
        this.networkConnection = networkConnection;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return Objects.requireNonNullElse(massage, "");
    }

    @Override
    public void run() {
        while (true){
            String massage = "";
            Object obj = networkConnection.read();
            massage =(String) obj;
            if (!getMassage().equals(massage)){
                setMassage(massage);
                System.out.println("Received : "+massage);
            }
        }
    }
}
