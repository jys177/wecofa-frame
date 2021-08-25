package wecofa.frame.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HomeController {
    @GetMapping(path = "/main/hello.do")
    public HashMap hello(){
        HashMap result = new HashMap();
        result.put("message","안녕하세요");
        return result;
    }
}
