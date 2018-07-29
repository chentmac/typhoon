package util;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;


public class JmsUtil {
	private JmsUtil() {}
	
	private static ConnectionFactory factory;
	private static Connection connection;
	private static final String URL="tcp://localhost:61616";
	
	static {
		try {
			factory=new ActiveMQConnectionFactory(URL);
			connection = factory.createConnection();
			connection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	private static Connection getConnection() {
		return connection;
	}
	
	public static Session getSession(boolean transacted,int acknowledgeMode) {
		Session session=null;
		try {
			session=connection.createSession(transacted, acknowledgeMode);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public static void closeResource(Session session,MessageProducer producer,MessageConsumer consumer) {
		try {
			if(consumer!=null)consumer.close();
			if(producer!=null)producer.close();
			if(session!=null)session.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
