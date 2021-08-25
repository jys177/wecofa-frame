package wecofa.frame.member.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wecofa.frame.member.user.entity.User;
import wecofa.frame.web.Message;
import wecofa.frame.web.resolver.LoginUser;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(path = "/login_user" , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getLoginUser(@LoginUser User user){
        logger.debug("Resolve LoginUser : {} ",user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/login_user/message" , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> getLoginUserMessage(@LoginUser User user){
        logger.debug("Resolve LoginUser : {} ",user);
        Message message = new Message(HttpStatus.OK,"SUCCESS",user);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }
}
