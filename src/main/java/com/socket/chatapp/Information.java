package com.socket.chatapp;

public class Information {
    private final String username;
    private final NetworkConnection networkConnection;

    public Information(String username, NetworkConnection networkConnection) {

        this.username = username;
        this.networkConnection = networkConnection;
    }

    public NetworkConnection getNetworkConnection() {
        return networkConnection;
    }
}
