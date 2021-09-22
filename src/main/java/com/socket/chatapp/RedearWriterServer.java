package com.socket.chatapp;

import java.util.Map;

public class RedearWriterServer implements Runnable {
    private String username;
    private NetworkConnection networkConnection;
    private Map<String, Information> clinets;

    public RedearWriterServer(String username, NetworkConnection networkConnection, Map<String, Information> clinets) {
        this.username = username;
        this.networkConnection = networkConnection;
        this.clinets = clinets;
    }

    @Override
    public void run() {
        while (true) {
            String actualMassage = getActualMassage();
            System.out.println(actualMassage);
            if (actualMassage.toLowerCase().contains("list")){
                System.out.println("List asked..."+ actualMassage);
                String[] words = actualMassage.split("\\$");
                /*
                  words[0] = sender name
                  words[1] = receiver name
                  words[2] = keywords
                  words[3] = massage
                 */
                System.out.println("Client list: \n"+clinets);
                Information information = clinets.get(words[0]);
                String massageTosend = new String("list of clients.... \n");
                for (Map.Entry<String, Information> entry: clinets.entrySet()){
                    String key = entry.getKey();
                    massageTosend = massageTosend + key + "\n";
                }
                Object object = massageTosend;
                System.out.println("sending.... "+massageTosend );
                information.getNetworkConnection().write(massageTosend);
            }
            if (actualMassage.toLowerCase().equals("ip")){
                String[] words = getActualMassage().split("\\$");

                System.out.println("Client list: \n"+clinets);
                Information information = clinets.get(words[0]);
                String msgToSend = new String("your port: \n");
                msgToSend+=information.getNetworkConnection().getSocket().getLocalAddress().getHostAddress();
                Object obj = msgToSend;
                System.out.println("Sending..."+msgToSend);
                information.getNetworkConnection().write(obj);

            }
            if (actualMassage.toLowerCase().contains("send")){
                String[] words = getActualMassage().split("\\$");

                Information information = clinets.get(words[1]);
                String msgToSend = words[0] + " says: " + words[3];
                Object obj = msgToSend;
                System.out.println("Sending... "+msgToSend);
                information.getNetworkConnection().write(obj);
            }
        }
    }

    private String getActualMassage() {
        Object obj = networkConnection.read();
        Data data = (Data) obj;
        return data.message;
    }
}
