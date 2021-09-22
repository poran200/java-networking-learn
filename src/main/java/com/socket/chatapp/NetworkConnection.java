package com.socket.chatapp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkConnection {
     Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    public NetworkConnection(Socket socket) throws IOException {
        socket = socket;
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    public NetworkConnection(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }
    public void write(Object object){
        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            System.out.println("Failed to  write.......");
        }
    }
    public Object read(){
        Object obj = null;
        try {
            obj = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to  read.......");
        }
        return obj;
    }

    public Socket getSocket() {
        return socket;
    }
}
