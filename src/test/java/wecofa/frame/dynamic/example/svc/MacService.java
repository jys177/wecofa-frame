package wecofa.frame.dynamic.example.svc;

import org.springframework.stereotype.Service;
import wecofa.frame.dynamic.example.interceptor.SampleServiceInterceptor;
import wecofa.frame.dynamic.service.ServiceInterface;

@Service("macService")
public class MacService implements ServiceInterface {
    private final String serviceId="Mac";
    private final SampleServiceInterceptor serviceInterceptor;

    public MacService(SampleServiceInterceptor serviceInterceptor) {
        this.serviceInterceptor = serviceInterceptor;
    }

    @Override
    public void execute(){
        serviceInterceptor.preProcess();
        System.out.println(serviceId);
        serviceInterceptor.postProcess();
    }
    @Override
    public String getServiceId() {
        return serviceId;
    }
}
