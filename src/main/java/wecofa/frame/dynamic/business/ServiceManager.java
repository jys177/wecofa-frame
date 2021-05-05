package wecofa.frame.dynamic.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wecofa.frame.dynamic.business.interceptor.SystemInterceptor;
import wecofa.frame.dynamic.service.ServiceInterface;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ServiceManager {
    private final Map<String,ServiceInterface> serviceMap;

    private final SystemInterceptor systemInterceptor;

    @Autowired
    public ServiceManager(List<ServiceInterface> serviceInterfaces, SystemInterceptor systemInterceptor){
        this.serviceMap=serviceInterfaces.stream().collect(Collectors.toMap(ServiceInterface::getServiceId,Function.identity()));
        this.systemInterceptor=systemInterceptor;
    }

    public void executeService(String serviceId){
        ServiceInterface service=serviceMap.get(serviceId);
        systemInterceptor.beforeExecute();
        service.execute();
        systemInterceptor.afterExecute();
    }

}
