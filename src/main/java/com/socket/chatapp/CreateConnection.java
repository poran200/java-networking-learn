package com.socket.chatapp;

import java.util.Map;

public class CreateConnection implements Runnable {
    private final Map<String, Information> clinets;
    private final NetworkConnection networkConnection;

    public CreateConnection(Map<String, Information> clinets, NetworkConnection networkConnection) {
        this.clinets = clinets;
        this.networkConnection = networkConnection;
    }

    @Override
    public void run() {
        Object userObj = networkConnection.read();
        String username = (String) userObj;
        System.out.println("User: "+username+" connected");
        clinets.put(username,new Information(username,networkConnection));
        System.out.println("HasMap updated "+clinets);
        new Thread(new RedearWriterServer(username,networkConnection,clinets)).start();
    }
}
