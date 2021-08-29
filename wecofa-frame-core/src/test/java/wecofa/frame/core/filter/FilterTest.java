package wecofa.frame.core.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/context-main.xml"})
@WebAppConfiguration
public class FilterTest {

    private final static Logger logger = LoggerFactory.getLogger(FilterTest.class);

    @Autowired
    protected WebApplicationContext context;
    protected MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Before
    public void setup(){
        this.mockMvc=MockMvcBuilders.webAppContextSetup(this.context)
                .build();
    }

    @Test
    public void callFilterService() throws Exception{
        SampleVo sampleVo =new SampleVo();
        sampleVo.setSampleId("SP0001");
        sampleVo.setSampleName("SPN001");
        String content=objectMapper.writeValueAsString(sampleVo);
        logger.debug("content : "+content);
        this.mockMvc.perform(post("/samples/1.do")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
