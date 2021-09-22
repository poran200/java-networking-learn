package com.socket.thread.sync;

public class Printer {
    synchronized void  printAssignment(Person person){
        System.out.println(person.getName() +"-> print started.......... ");
        for (int i = 0; i < person.getPages(); i++) {
            System.out.println(person.getName() +" printed page# "+(i+1));
        }
        System.out.println("print end.......... ");
    }

    public void printAssignment(String name, int pages) {
        System.out.println("print started.......... ");
        for (int i = 0; i < pages; i++) {
            System.out.println(name +" printed page# "+(i+1));
        }
        System.out.println("print end.......... ");
    }
}
