package wecofa.frame.core.aop;

import org.aspectj.lang.JoinPoint;

public class AopUtil {
    public static String getCallLocation(JoinPoint joinPoint){
        String typeName=joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        return typeName+" : "+methodName;
    }
}
