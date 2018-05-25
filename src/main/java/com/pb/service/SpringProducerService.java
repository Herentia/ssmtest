package com.pb.service;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class SpringProducerService {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	/**
	 * 发送消息到默认目的地
	 */
	public void sendMessage(final DeferredResult<Object> deferredResult) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage((Serializable) deferredResult);
			}
		});
	}
	
	/**
	 *发送字符串消息到mq
	 * @param str
	 */
	public void sendMessageStr(final String str) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(str);
			}
		});
	}

}
