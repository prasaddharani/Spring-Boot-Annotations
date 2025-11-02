package com.example.annotations.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class RequestCountFilter implements Filter {

    private int counter;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("RequestCountFilter preprocessing");
        counter++;
        request.setAttribute("counter", counter);
        if (response instanceof HttpServletResponse httpServletResponse) {
            httpServletResponse.addHeader("X-Request-Count", String.valueOf(counter));
        }
        filterChain.doFilter(request, response);

        log.info("RequestCountFilter postprocessing counter: {}", counter);
    }
}
