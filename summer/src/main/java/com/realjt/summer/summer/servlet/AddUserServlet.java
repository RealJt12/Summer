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
import com.realjt.summer.summer.domain.User;

public class AddUserServlet extends HttpServlet
{
	private static final long serialVersionUID = 6715728055633283308L;

	private static final Logger log = LoggerFactory.getLogger(AddUserServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		UserDao userDao = (UserDao) applicationContext.getBean("userDao");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int sex = Integer.valueOf(request.getParameter("sex"));
		int age = Integer.valueOf(request.getParameter("age"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setAge(age);
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);

		log.info("add user " + user);

		userDao.add(user);

		response.sendRedirect("/summer/allusers");
	}

}
