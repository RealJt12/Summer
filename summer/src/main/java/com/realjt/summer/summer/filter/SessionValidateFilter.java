package com.realjt.summer.summer.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lettry on 2017/6/25.
 */
public class SessionValidateFilter implements Filter
{
	private static final Logger log = LoggerFactory
			.getLogger(SessionValidateFilter.class);

	private static final String AUTHENTICATE = "AUTHENTICATE";

	private static final String LOGIN = "login";

	public void init(FilterConfig filterConfig) throws ServletException
	{

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse reponse = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();

		String uri = request.getRequestURI();
		log.info("enter validate url = {}", uri);

		if (uri.indexOf(LOGIN) == -1)
		{
			Object obj = session.getAttribute(AUTHENTICATE);
			if (obj == null)
			{
				reponse.sendRedirect("login");
				log.info("invalid");

				return;
			}
			else
			{
				// TODO do valid session
				log.info("valid ok");
			}
		}
		else
		{
			// TODO
			session.setAttribute(AUTHENTICATE, new Object());
			log.info("generate authenticator");
		}

		log.info("exit SessionValidateFilter");

		filterChain.doFilter(request, reponse);
	}

	public void destroy()
	{

	}

}