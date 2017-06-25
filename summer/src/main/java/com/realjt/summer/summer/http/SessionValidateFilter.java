package com.realjt.summer.summer.http;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lettry on 2017/6/25.
 */
public class SessionValidateFilter implements Filter {

  private static final Logger log = LoggerFactory
      .getLogger(SessionValidateFilter.class);


  public void init(FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse reponse = (HttpServletResponse) servletResponse;
    HttpSession session = request.getSession();
    if (session == null) {
      //TODO do valid session
      reponse.sendRedirect("login.jsp");
      log.info("SessionValidateFilter");
      return;

    }

    log.info("exit SessionValidateFilter");


    filterChain.doFilter(request, reponse);
  }

  public void destroy() {

  }
}
