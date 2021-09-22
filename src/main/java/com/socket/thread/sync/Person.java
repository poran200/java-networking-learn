package com.socket.thread.sync;

import java.awt.print.PrinterJob;

public class Person implements Runnable {
    private final Printer printer;
    private final String name;
    private final int pages;
    private Thread t;

    public Person(Printer printer, String name, int pages) {
        this.printer = printer;
        this.name = name;
        this.pages = pages;
        this.t = new Thread(this, name);
        t.start();
    }


    @Override
    public void run() {
        printer.printAssignment(this);
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }
}
