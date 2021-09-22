package com.socket.thread.sync;

public class Synchronization {
    public static void main(String[] args) {
        Printer printer = new Printer();
        new Person(printer,"Poran",5);
        new Person(printer,"Jalal",10);
    }
}
