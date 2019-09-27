package com.javainuse.consumer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.javainuse.producer.MyFlag;

public class Consumer implements Runnable {
	
	boolean flag;
	MyFlag myFlag;
	public Consumer(boolean flag){
		this.flag = flag;
	}
	
	public Consumer(MyFlag myFlag){
		this.myFlag = myFlag;
	}

    @Override
    public void run() {
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            //Create Connection
            Connection connection = factory.createConnection();

            // Start the connection
            connection.start();

            // Create Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //Create queue
            Destination queue = session.createQueue("MyQueue");

            MessageConsumer consumer = session.createConsumer(queue);
            System.out.println("Consumer Before Flag ::"+myFlag.isFlag());
            while(myFlag.isFlag()){
                Message message = consumer.receive(1000);

                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println("Consumer Received: " + text);
                }
                System.out.println("Consumer Thread running");
            }
            System.out.println("Consumer After Flag ::"+myFlag.isFlag());
            session.close();
            connection.close();
        }
        catch (Exception ex) {
            System.out.println("Exception Occured");
        }

    }

}
