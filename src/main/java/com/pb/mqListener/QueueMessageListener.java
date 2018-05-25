package com.pb.mqListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueMessageListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			String str = tm.getText();
			System.out.println("接收到文本消息：====》》》》" + str);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
