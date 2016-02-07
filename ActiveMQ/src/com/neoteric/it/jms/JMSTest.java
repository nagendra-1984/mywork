package com.neoteric.it.jms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JMSTest
 */
public class JMSTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JMSTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String body = "";

	          try {
	              InitialContext init = new InitialContext();
	              System.out.println("&^& before Destination ^%^");
	              javax.jms.Queue destination =
	                  (javax.jms.Queue) init.lookup("java:comp/env/jms/myQueue");
	              System.out.println("^%^ After destination ^%^");
	              ConnectionFactory connectionFactory =
	                  (ConnectionFactory) init.lookup("java:comp/env/jms/ConnectionFactory");
	              Connection connection = connectionFactory.createConnection();
	              Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

	              TextMessage message = session.createTextMessage();
	              message.setText("My text message was send and received");
	              connection.start();

	              MessageProducer producer = session.createProducer(destination);
	              producer.setDeliveryMode(DeliveryMode.PERSISTENT);
	              producer.send(message);
	              message = null;

	              MessageConsumer consumer = session.createConsumer(destination);
	              message = (TextMessage) consumer.receive(1000);
	              if( message!=null ) {
	                  body = message.getText();
	              }

	              producer.close();
	              consumer.close();
	              session.close();
	              connection.close();

	          } catch (Exception e) {
	              System.out.println(e.toString());
	              e.printStackTrace();
	          }

	        out.println("<html>");
	        out.println("<head>");

		    String title = "JMS Test";

		    out.println("<title>" + title + "</title>");
	        out.println("</head>");
	        out.println("<body bgcolor=\"white\">");

	        out.println("<h1>" + title + "</h1>");

	        out.println("<p>The message contains many changes jan release\"" + body + "\".</p>");

	        out.println("</body>");
	        out.println("</html>");
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
