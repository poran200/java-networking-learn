package com.socket.chatapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("server started on port: "+serverSocket.getLocalPort());
        Map<String, Information> clinets = new HashMap<>();
        while (true){
            Socket socket = serverSocket.accept();
            NetworkConnection networkConnection = new NetworkConnection(socket);
            new Thread( new CreateConnection(clinets,networkConnection)).start();
        }
    }
}
