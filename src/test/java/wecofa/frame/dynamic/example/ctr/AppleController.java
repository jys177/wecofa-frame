package wecofa.frame.dynamic.example.ctr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wecofa.frame.dynamic.business.ServiceManager;

@Controller
public class AppleController {

    private final ServiceManager serviceManager;

    @Autowired
    public AppleController(ServiceManager serviceManager){
        this.serviceManager=serviceManager;
    }

    @GetMapping(value = "/{serviceId}/device")
    public void getDevice(@PathVariable String serviceId){
        serviceManager.executeService(serviceId);
    }

    @GetMapping(value = "/iphone")
    public String getIPhone(){
        String serviceId = "iPhone";
        serviceManager.executeService(serviceId);
        return serviceId;
    }




}
