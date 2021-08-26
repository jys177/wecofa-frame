package wecofa.frame.member.customer.controller;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/servlet-context.xml","classpath:/spring/context-main.xml"})
@WebAppConfiguration
public class CustomerControllerTest {
    private final static Logger logger = LoggerFactory.getLogger(CustomerControllerTest.class);


    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.context)
                .build();
    }
    @Test
    public void callCustomerList() throws Exception{
        this.mockMvc.perform(get("/customers/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    /*@Test
    public void callCustomer() throws Exception{
        this.mockMvc.perform(get("/customers/2/{cusId}","CUS-00002"))
                .andDo(print())
                .andExpect(status().isOk());
    }*/
    /*@Test
    public void callCustomerMessage() throws Exception{
        this.mockMvc.perform(get("/customers/3/{cusId}","CUS-00002"))
                .andDo(print())
                .andExpect(status().isOk());
    }*/
}
