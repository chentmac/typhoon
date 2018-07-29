package servlet;




import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.servlet.http.HttpServlet;

import org.apache.activemq.command.ActiveMQQueue;

import service.JMSService;
import service.impl.JMSServiceImpl;
import util.JmsUtil;


public class JMSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Destination queue=new ActiveMQQueue("AMCQ");
    private static final Destination queue1=new ActiveMQQueue("AMCQ2");
    private JMSService jmsService=new JMSServiceImpl();
	@Override
	public void init() {
		String path=getServletContext().getRealPath("/");
		System.out.println(path);
		try {
			Session sen=JmsUtil.getSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageConsumer consumer=sen.createConsumer(queue);
			MessageConsumer consumer2=sen.createConsumer(queue1);
			jmsService.addAd(consumer, path);
			jmsService.addMerchant(consumer2, path);
		} catch (JMSException e1) {
			e1.printStackTrace();
		}
	}
}
