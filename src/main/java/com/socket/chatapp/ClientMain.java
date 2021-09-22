package com.socket.chatapp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect( (new InetSocketAddress("www.google.com",80)));
        System.out.println("Client Started .....");

        System.out.println(socket.getLocalAddress().getHostAddress());
        NetworkConnection networkConnection = new NetworkConnection(socket.getLocalAddress().getHostAddress(),12345);

        System.out.println("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        networkConnection.write(userName);

        Thread readerThread = new Thread(new Reader(networkConnection));
        Thread writerThread = new Thread(new Writer(networkConnection));
        readerThread.start();
        writerThread.start();
        try {
            readerThread.join();
            writerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread exited..");
        }
    }
}
