package com.neoteric.it.jms;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueSession;
import javax.jms.QueueReceiver;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

public class Receiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
		
			Properties env = new Properties();			
			env.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			env.put(Context.PROVIDER_URL, "tcp://localhost:61616");
			env.put("queue.queueSampleQueue","MyNeoQueue");
			// get the initial context
			InitialContext ctx = new InitialContext(env);
	
			// lookup the queue object
			Queue queue = (Queue) ctx.lookup("queueSampleQueue");
	
			// lookup the queue connection factory
			QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup("QueueConnectionFactory");
	
			// create a queue connection
			QueueConnection queueConn = connFactory.createQueueConnection();
	
			// create a queue session
			QueueSession queueSession = queueConn.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
	
			// create a queue receiver
			QueueReceiver queueReceiver = queueSession.createReceiver(queue);
	
			// start the connection
			queueConn.start();
	
			// receive a message
			TextMessage message = (TextMessage) queueReceiver.receive();
			MapMessage mapMessage = (MapMessage)queueReceiver.receive();
	
			// print the message
			System.out.println("received: " + message.getText());
			System.out.println("^%^ Map Message ^%^"+mapMessage.getString("Name"));
			System.out.println("^%^ Map Message ^%^"+mapMessage.getString("Email"));
			
	
			
			// close the queue connection
			queueConn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
