package com.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(dispatcherTypes = {
    DispatcherType.FORWARD,
    DispatcherType.INCLUDE,
    DispatcherType.REQUEST},
    urlPatterns = {"/guvenli/*"}
)
public class GuvenlikFiltre implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(((HttpServletRequest)request).getSession().getAttribute("KId")==null){
            String adres=request.getServletContext().getContextPath();
            ((HttpServletResponse)response).sendRedirect(adres+"/giris.jsp");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
    
}
