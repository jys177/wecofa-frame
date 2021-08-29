package wecofa.frame.core.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class WcfMessageListener<I,O> implements SessionAwareMessageListener {

    private final MessageConverter messageConverter;
    //TODO service inject

    @Autowired
    public WcfMessageListener(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        //message to object
        //service call
        //object to message
        //send
        MessageProducer sender = session.createProducer(message.getJMSReplyTo());
        I input = (I) messageConverter.fromMessage(message);
        O response = (O) callService(input);
        Message responseMessage = messageConverter.toMessage(response,session);
        sender.send(responseMessage);
    }

    private O callService(I input){
        Object obj=input;
        O eco =(O) obj;
        return eco;
    }

}
