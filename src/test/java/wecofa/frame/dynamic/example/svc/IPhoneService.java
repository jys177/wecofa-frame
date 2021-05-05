package wecofa.frame.dynamic.example.svc;

import org.springframework.stereotype.Service;
import wecofa.frame.dynamic.service.ServiceInterface;
import wecofa.frame.dynamic.service.interceptor.ServiceInterceptor;

@Service
public class IPhoneService implements ServiceInterface {

    private final String serviceId="iPhone";

    private final ServiceInterceptor serviceInterceptor;

    public IPhoneService(ServiceInterceptor serviceInterceptor){
        this.serviceInterceptor=serviceInterceptor;
    }


    @Override
    public void execute() {
        this.serviceInterceptor.preProcess();
        System.out.println(this.serviceId);
        this.serviceInterceptor.postProcess();
    }

    @Override
    public String getServiceId() {
        return this.serviceId;
    }
}
