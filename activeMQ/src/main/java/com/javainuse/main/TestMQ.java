package com.javainuse.main;

import com.javainuse.consumer.Consumer;
import com.javainuse.producer.MyFlag;
import com.javainuse.producer.Producer;

public class TestMQ {
	
	volatile static boolean flag = true;

    public static void main(String[] args) {
    	 
    	MyFlag myFlag = new MyFlag(flag);
        Producer producer = new Producer(myFlag);
        Consumer consumer = new Consumer(myFlag);
 
        Thread producerThread = new Thread(producer,"Producer");
        producerThread.start();        
        System.out.println("Main Flag::"+myFlag.isFlag());
        
        Thread consumerThread = new Thread(consumer,"Consumer");
        consumerThread.start();
        
        
        Thread producerThread1 = new Thread(producer);
        producerThread1.start(); 
    }
}
