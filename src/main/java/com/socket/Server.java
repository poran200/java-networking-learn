package com.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

           startServer();
    }

    private static void startServer() {
        try(ServerSocket serverSocket = new ServerSocket(8080)){
            System.out.println("Server started...");

            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Client Started.....");
                new ServerThread(socket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void wirteMassage(Socket socket,String massage) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(massage.toUpperCase());
    }

    private static String readMassage(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        String massager = (String) inputStream.readObject();
        System.out.println("massager  from client = " + massager);
        return massager;
    }
}
