package wecofa.frame.core.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;


/**
 *
 * */
public class WcfMessageAdaptor<I,O> {
    private final static Logger logger = LoggerFactory.getLogger(WcfMessageAdaptor.class);

    private final JmsTemplate jmsTemplate;
    private final MessageConverter messageConverter;

    @Autowired
    public WcfMessageAdaptor(JmsTemplate jmsTemplate, MessageConverter messageConverter) {
        this.jmsTemplate = jmsTemplate;
        this.messageConverter=messageConverter;
    }

    public O sender(I inputVo){
        Message responseMessage=null;
        O response =null;

        responseMessage=jmsTemplate.sendAndReceive((session)->(messageConverter.toMessage((I)inputVo,session)));
        try {
            response=(O) messageConverter.fromMessage(responseMessage);
        }catch (JMSException e ){
            logger.error("Exception while converting message to vo.",e);
            //TODO ERROR 처리
        }
        return response;
    }


}
