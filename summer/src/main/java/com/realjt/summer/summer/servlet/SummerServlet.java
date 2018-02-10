package com.realjt.summer.summer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.realjt.summer.summer.dao.UserDao;

public class SummerServlet extends HttpServlet
{
	private static final long serialVersionUID = -3903640785697216419L;

	private static final Logger log = LoggerFactory.getLogger(SummerServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		UserDao userDao = (UserDao) applicationContext.getBean("userDao");

		log.debug("realjt");

		response.getWriter().write("developer total:" + userDao.count() + "<br>" + userDao.query());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

}