package wecofa.frame.dynamic.example.ctr;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/servlet-context.xml"})
@WebAppConfiguration
public class ControllerTest {

    @Autowired
    protected WebApplicationContext context;
    protected MockMvc mockMvc;


    @Before
    public void setup(){
        this.mockMvc=MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void ControllerCall() throws Exception{
        this.mockMvc.perform(get("/iphone"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deviceIdCall() throws Exception{
        this.mockMvc.perform(get("/{serviceId}/device","Macbook"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void macServiceCall() throws Exception{
        this.mockMvc.perform(get("/{serviceId}/device","Mac"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
