package wecofa.frame.core.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/context-main.xml"})
public class AspectServiceTest {
    private final static Logger logger = LoggerFactory.getLogger(AspectServiceTest.class);
    @Autowired
    private AopSampleService aopSampleService;

    @Test
    public void serviceTest(){
        Object output=aopSampleService.executeService("abc1234");
        logger.debug("output : {}",output);
    }

}
