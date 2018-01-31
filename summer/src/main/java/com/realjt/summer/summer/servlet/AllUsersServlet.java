package com.realjt.summer.summer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realjt.summer.summer.domain.User;

public class AllUsersServlet extends HttpServlet
{
	private static final long serialVersionUID = -2567273285279086423L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		
		List<User> allUsers = new ArrayList<User>();
		
		User user = new User();
		user.setId(0);
		user.setUsername("realjt");
		user.setPassword("juntian");
		user.setSex(0);
		user.setAge(20);
		user.setPhone("12345678900");
		user.setEmail("realjt2012@gmail.com");
		user.setAddress("nanjing");
		
		allUsers.add(user);
		
		user = new User();
		user.setId(1);
		user.setUsername("juntian");
		user.setPassword("2010");
		user.setSex(0);
		user.setAge(26);
		user.setPhone("15088888888");
		user.setEmail("realjt2012@gmail.com");
		user.setAddress("shenzhen");
		
		allUsers.add(user);
		
		request.setAttribute("allUsers", allUsers);
		request.getRequestDispatcher("/allusers.jsp").forward(request, response);
	}

}