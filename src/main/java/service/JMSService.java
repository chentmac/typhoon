package service;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;

public interface JMSService {
	public void addMerchant(MessageConsumer consumer,String path) throws JMSException;
	public void addAd(MessageConsumer consumer,String path) throws JMSException;
	
}
