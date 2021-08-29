package wecofa.frame.core.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AopSampleController {
    private static final Logger logger = LoggerFactory.getLogger(AopSampleController.class);
    private final AopSampleService sampleService;

    @Autowired
    public AopSampleController(AopSampleService sampleService){
        this.sampleService=sampleService;
    }

    @GetMapping("/callAopService.do")
    public Object callAopService(){
        logger.info("[PROC] Service Call");
        Object result= sampleService.executeService("Sample Work");
        logger.info("[PROC] Service Return {}",result);
        return result;
    }

}
