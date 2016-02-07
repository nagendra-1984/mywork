package com.neoteric.it.jms;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.QueueSession;
import javax.jms.QueueReceiver;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

public class TopicReceiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			env.put(Context.PROVIDER_URL, "tcp://localhost:61616");
			env.put("topic.topicSampleTopic", "MyNeoTopic");
			// get the initial context
			InitialContext ctx = new InitialContext(env);
	
			// lookup the queue object
			Topic topic = (Topic) ctx.lookup("topicSampleTopic");
	
			// lookup the queue connection factory
			TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup("TopicConnectionFactory");
	
			// create a queue connection
			TopicConnection topicConn = connFactory.createTopicConnection();
	
			// create a queue session
			TopicSession topicSession = topicConn.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);
	
			// create a queue receiver
			MessageConsumer topicReceiver = topicSession.createConsumer(topic);
			
	
			// start the connection
			topicConn.start();
	
			// receive a message
			TextMessage message = (TextMessage) topicReceiver.receive();
			//MapMessage mapMessage = (MapMessage)topicReceiver.receive();
	
			// print the message
			System.out.println("received: " + message.getText());
			//System.out.println("^%^ Map Message ^%^"+mapMessage.getString("Name"));
		//	System.out.println("^%^ Map Message ^%^"+mapMessage.getString("Email"));
			
	
			
			// close the queue connection
			topicConn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
