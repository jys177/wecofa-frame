package wecofa.frame.core.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class SampleFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(SampleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Filter init Method");
        logger.info("filter config [SampleParam : "+filterConfig.getInitParameter("SampleParam")+"]");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Filter Start !");
        filterChain.doFilter(servletRequest,servletResponse);
        logger.info("Filter End !");
    }

    @Override
    public void destroy() {
        logger.info("Filter destroy Method");
    }
}
