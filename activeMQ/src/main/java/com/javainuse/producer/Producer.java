package com.javainuse.producer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer implements Runnable {
	
	boolean flag;
	MyFlag myFlag;
	public Producer(boolean flag){
		
		this.flag = flag;
	}
	
	public Producer(MyFlag myFlag){
		
		this.myFlag = myFlag;
	}

    public void run() {
        try { // Create a connection factory.
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            //Create connection.
            Connection connection = factory.createConnection();

            // Start the connection
            connection.start();

            // Create a session which is non transactional
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create Destination queue
            Destination queue = session.createQueue("MyQueue");

            // Create a producer
            MessageProducer producer = session.createProducer(queue);

            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            String msg = "Hello World";

            //insert message
            for(int i=0; i<10; i++){
            
            	TextMessage message = session.createTextMessage(msg+"-"+i);
                System.out.println("Producer Sent: " + msg+"-"+i);
                producer.send(message);
            }
            
            Thread.sleep(100000);
            myFlag.setFlag(false);
            System.out.println("Producer Flag ::"+myFlag.isFlag());
            session.close();
            connection.close();
        }
        catch (Exception ex) {
            System.out.println("Exception Occured "+ex);
        }

    }

}
