/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco_api.presentation.security.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.business.service.security.Authorization;
import com.fpmislata.banco_api.presentation.security.WebSession;
import com.fpmislata.banco_api.presentation.security.WebSessionProvider;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author alumno
 */
public class FilterImplSecurity implements Filter {

    @Autowired
    WebSessionProvider webSessionProvider;

    @Autowired
    Authorization authorization;

    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(httpServletRequest.getServletContext());
        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);

        WebSession webSession = webSessionProvider.getWebSession(httpServletRequest, httpServletResponse);
        Usuario usuario = null;

        if (webSession != null) {
            usuario = webSession.getUsuario();
        }

        if (authorization.isAuthorizedURL(usuario, httpServletRequest.getRequestURI(), httpServletRequest.getMethod())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpServletResponse.getWriter().println("<h1> Necesitas Logearte </h1>");
        }
    }

    @Override
    public void destroy() {

    }

}
