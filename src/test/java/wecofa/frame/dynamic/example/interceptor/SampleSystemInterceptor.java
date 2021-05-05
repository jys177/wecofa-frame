package wecofa.frame.dynamic.example.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wecofa.frame.dynamic.business.interceptor.SystemInterceptor;

@Component
public class SampleSystemInterceptor implements SystemInterceptor {

    @Autowired
    public SampleSystemInterceptor(){
        super();
    }

    @Override
    public void beforeExecute() {
        System.out.println("before");
    }

    @Override
    public void afterExecute() {
        System.out.println("after");
    }
}
