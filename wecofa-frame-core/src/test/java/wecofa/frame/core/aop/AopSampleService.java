package wecofa.frame.core.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AopSampleService {
    private static final Logger logger = LoggerFactory.getLogger(AopSampleService.class);

    @Autowired
    public AopSampleService(){
        super();
    }

    public Object executeService(String input){
        Object output=null;
        logger.info("[PROC] :"+input);
        output=input.toUpperCase();
        logger.info("[PROC] :"+output);
        return output;
    }
}
