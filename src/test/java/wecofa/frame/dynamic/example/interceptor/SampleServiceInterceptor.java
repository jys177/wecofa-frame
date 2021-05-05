package wecofa.frame.dynamic.example.interceptor;

import org.springframework.stereotype.Component;
import wecofa.frame.dynamic.service.interceptor.ServiceInterceptor;

@Component
public class SampleServiceInterceptor implements ServiceInterceptor {

    public SampleServiceInterceptor() {
    }

    @Override
    public void preProcess() {
        System.out.println("before service");
    }

    @Override
    public void postProcess() {
        System.out.println("after service");
    }
}
