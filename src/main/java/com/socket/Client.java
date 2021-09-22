package com.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
          try{
              ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
              ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
              new WriterThread(outputStream,"Client-1");
              new ReaderThread(inputStream,"Client-1");
          }catch (Exception e){
              e.printStackTrace();
          }

    }

}
