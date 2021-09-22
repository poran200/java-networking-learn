package com.socket.thread.pubandsub;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class PcBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        Producer producer = new Producer(queue, "producer");
        Consumer consumer = new com.socket.thread.pubandsub.Consumer(queue,"consumer-1");
        Consumer consumer2 = new com.socket.thread.pubandsub.Consumer(queue,"consumer-2");
        Consumer consumer3 = new com.socket.thread.pubandsub.Consumer(queue,"consumer-3");
    }
}
