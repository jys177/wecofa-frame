package wecofa.frame.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import wecofa.frame.aop.AopUtil;

@Component
@Aspect
public class ControllerAspect {

    private final static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Around("within(@org.springframework.stereotype.Controller *)")
    public void aroundController(ProceedingJoinPoint joinPoint){
        try {
            logger.info("[Ctr] around : "+AopUtil.getCallLocation(joinPoint));
            joinPoint.proceed();
            logger.info("[Ctr] around : "+AopUtil.getCallLocation(joinPoint));
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    @Before("within(@org.springframework.stereotype.Controller *)")
    public void beforeController(JoinPoint joinPoint){
        logger.info("[Ctr] before : "+AopUtil.getCallLocation(joinPoint));
    }

    @After("within(@org.springframework.stereotype.Controller *)")
    public void afterController(JoinPoint joinPoint){
        logger.info("[Ctr] after : "+ AopUtil.getCallLocation(joinPoint));
    }

    @AfterReturning("within(@org.springframework.stereotype.Controller *)")
    public void afterReturningController(JoinPoint joinPoint){
        logger.info("[Ctr] afterReturning : "+AopUtil.getCallLocation(joinPoint));
    }
    @AfterThrowing("within(@org.springframework.stereotype.Controller *)")
    public void afterThrowingController(JoinPoint joinPoint){
        logger.info("[Ctr] afterThrowing : "+AopUtil.getCallLocation(joinPoint));
    }
}
