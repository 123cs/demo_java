package cs.service.core.filter;


import org.apache.logging.log4j.LogManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    /**
     * Log basic info
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURI();

        LogManager.getLogger(getClass()).debug("Request started: {}", url);

        long start = System.currentTimeMillis();

        try {
            chain.doFilter(request, response);
        } finally {
            long delta = System.currentTimeMillis() - start;

            LogManager.getLogger(getClass()).info("Request completed in {}ms: {}", delta, url);
        }
    }

    @Override
    public void destroy() {

    }
}
