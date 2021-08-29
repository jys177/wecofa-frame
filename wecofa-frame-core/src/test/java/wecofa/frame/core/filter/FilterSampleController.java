package wecofa.frame.core.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class FilterSampleController {
    private static final Logger logger = LoggerFactory.getLogger(FilterSampleController.class);


    @Autowired
    public FilterSampleController(){
        super();
    }

    @PostMapping(value = "/samples/1.do",produces = MediaType.APPLICATION_JSON_VALUE)
    public SampleVo insertMember(@RequestBody SampleVo sampleVo){
        logger.debug("input data ["+sampleVo+"]");
        return sampleVo;
    }
}
