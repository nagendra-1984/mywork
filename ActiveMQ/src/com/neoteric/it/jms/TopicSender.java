package com.neoteric.it.jms;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.activemq.command.Message;

import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.QueueSender;
import javax.jms.DeliveryMode;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.QueueSession;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;

public class TopicSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
		
			// Using Active MQ Server , sending the Messages to the server 
			
			// Creating the Porperities required to create the Queue on Active MQ Server
			Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			env.put(Context.PROVIDER_URL, "tcp://localhost:61616");
			env.put("topic.topicSampleTopic", "MyNeoTopic");
			
			// get the initial context
			InitialContext ctx = new InitialContext(env);
	
			// lookup the topic object
			Topic topic = (Topic) ctx.lookup("topicSampleTopic");
			
			// lookup the Topic connection factory
			TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup("TopicConnectionFactory");
			
			// create a queue connection
			TopicConnection topicConn = connFactory.createTopicConnection();
	
			// create a queue session
			TopicSession topicSession = topicConn.createTopicSession(false,Session.DUPS_OK_ACKNOWLEDGE);
	
			// create a queue sender
			MessageProducer topicProducer = topicSession.createProducer(topic);
			topicProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
	
			
			TextMessage message = topicSession.createTextMessage("Hello Topic ,Another This is Nagendra");
			
			MapMessage mapMessage =  topicSession.createMapMessage();
			mapMessage.setString("Name", "Nagendra Reddy");
			mapMessage.setString("Email", "Nagendra_Komireddy@gmail.com");
			
			//topicProducer.send(mapMessage);
			// send the message
			topicProducer.send(message);
	
			System.out.println("sent: " + message.getText());
			
	
			topicConn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
