package wecofa.frame.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;
import wecofa.frame.web.resolver.LoginUserMethodArgumentResolver;

import java.io.IOException;
import java.util.List;


/**
 * main page redirect 후 react에서 routing을 통해 return 할 view 에 해당하는 화면 url 연결
 * */

@Configuration
@EnableWebMvc //WebMvc에 관련된 설정들을 import 할 수 있다.
public class WebConfig implements WebMvcConfigurer {
    //cors 설정
   /* @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/main/**")
                .allowedOrigins("http://localhost:3000");
    }*/

    private final LoginUserMethodArgumentResolver resolver;

    private final MappingJackson2HttpMessageConverter converter;

    @Autowired
    public WebConfig(LoginUserMethodArgumentResolver resolver,MappingJackson2HttpMessageConverter converter) {
        this.resolver = resolver;
        this.converter = converter;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(resolver);
    }

    /**
     * Message Converter : MappingJackson2HttpMessageConverter
     * */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter);
    }

    /**
     * 정적 URL 위치 설정
     * addResourceHandler : Mapping URL 설정
     * addResourceLocations : 정적 리소스 위치 설정
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/resources/static/js/**").addResourceLocations("classpath:/public/static/js/");
        //registry.addResourceHandler("/resources/static/css/**").addResourceLocations("classpath:/public/static/css/");
        //registry.addResourceHandler("/resources/public/**").addResourceLocations("/resources/public/");
        //registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/public/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver(){
                    @Override
                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
                        Resource requestedResource =location.createRelative(resourcePath);
                        if(requestedResource.exists()&&requestedResource.isReadable()){
                            return requestedResource;
                        }else{
                            return new ClassPathResource("/public/index.html");
                        }
                    }
                });
       // registry.addResourceHandler("/**").addResourceLocations("classpath:/public/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/index.html");
    }
}
