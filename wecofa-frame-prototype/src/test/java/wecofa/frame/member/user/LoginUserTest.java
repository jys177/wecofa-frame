package wecofa.frame.member.user;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import wecofa.frame.member.user.controller.UserController;
import wecofa.frame.member.user.entity.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/servlet-context.xml","classpath:/spring/context-main.xml"})
@WebAppConfiguration
public class LoginUserTest {

    private MockHttpSession session;

    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mockMvc;

    @Before
    public void before(){
        User user = new User();
        user.setUserId("UID0001");
        user.setUserName("UNM0001");
        session = new MockHttpSession();
        session.setAttribute("login_user",user);

        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.context)
                .build();
    }

    @After
    public void after(){
        session.clearAttributes();
        session=null;
    }

    @Test
    public void loginUserTest() throws Exception{
        this.mockMvc.perform(get("/users/user").session(session)
        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void loginUserTestMessage() throws Exception{
        this.mockMvc.perform(get("/users/user/message").session(session)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
