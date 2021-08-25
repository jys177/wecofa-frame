package wecofa.frame.web.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import wecofa.frame.member.user.entity.User;


@Component
public class LoginUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * Resolver가 적용 가능한지 검사하는 역할을 한다.
     * 해당 컨트롤러의 파라미터에 LoginUser 어노테이션이 붙어있는지를 검사해서 boolean 값을 리턴한다.
     * */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(LoginUser.class) // methodParameter 에 LoginUser 어노테이션이 붙었는지 확인한다.
                &&User.class.isAssignableFrom(methodParameter.getParameterType()); // methodParameter 가 User 클래스 객체인지 확인한다.
    }
    /**
     * 실제 Resolver 의 역할을 수행하는 메소드 이다.
     * 세션에서 "login_user" 에 대한 데이터를 가지고 온다.
     * */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Object resolved = null;
        // 세션에서 "login_user" 에 대한 데이터를 가지고 온다.
        User user = (User) nativeWebRequest.getAttribute("login_user", WebRequest.SCOPE_SESSION);
        if(user!=null){
            resolved=user;
        }else {
            resolved = new User();
        }
        return resolved;
    }
}
