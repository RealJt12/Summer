package com.realjt.summer.summer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.realjt.summer.summer.dao.UserDao;

public class DeleteUserServlet extends HttpServlet
{
	private static final long serialVersionUID = 3999757855515550006L;

	private static final Logger log = LoggerFactory.getLogger(DeleteUserServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		UserDao userDao = (UserDao) applicationContext.getBean("userDao");

		String id = request.getParameter("id");
		log.info("get delete user id = " + id);

		if (StringUtils.isNoneBlank(id))
		{
			userDao.delete(Integer.valueOf(id));
		}
		response.sendRedirect("/summer/allusers");
	}

}