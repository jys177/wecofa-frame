package wecofa.frame.core.aop;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/context-main.xml"})
@WebAppConfiguration
public class AspectTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AspectTest.class);
    @Autowired
    protected WebApplicationContext context;
    protected MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc=MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void callAopService() throws Exception{
        LOGGER.info("info");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        this.mockMvc.perform(get("/callAopService.do"))
  //              .andDo(print())
                .andExpect(status().isOk());
    }



}
