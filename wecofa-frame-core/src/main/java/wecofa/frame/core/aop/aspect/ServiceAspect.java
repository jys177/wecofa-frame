package wecofa.frame.core.aop.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import wecofa.frame.core.aop.AopUtil;

@Component
@Aspect
public class ServiceAspect {

    private final static Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

    @Around("within(@org.springframework.stereotype.Service *)")
    public Object aroundService(ProceedingJoinPoint joinPoint){
        Object output=null;
        try {
            logger.info("[Svc] around : "+AopUtil.getCallLocation(joinPoint));
            output=joinPoint.proceed();
            logger.info("[Svc] around : "+AopUtil.getCallLocation(joinPoint));
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return output;
    }

    @Before("within(@org.springframework.stereotype.Service *)")
    public void beforeService(JoinPoint joinPoint){

        logger.info("[Svc] before : "+ AopUtil.getCallLocation(joinPoint));
    }

    @After("within(@org.springframework.stereotype.Service *)")
    public void afterService(JoinPoint joinPoint){
        logger.info("[Svc] after : "+ AopUtil.getCallLocation(joinPoint));
    }

    @AfterReturning("within(@org.springframework.stereotype.Service *)")
    public void afterReturningService(JoinPoint joinPoint){
        logger.info("[Svc] afterReturning : "+ AopUtil.getCallLocation(joinPoint));
    }
    @AfterThrowing("within(@org.springframework.stereotype.Service *)")
    public void afterThrowingService(JoinPoint joinPoint){
        logger.info("[Svc] afterThrowing : "+AopUtil.getCallLocation(joinPoint));
    }
}
