package com.realjt.summer.summer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realjt.summer.summer.dao.UserDao;
import com.realjt.summer.summer.domain.User;

@Controller
public class UserController
{
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDao userDao;

	@RequestMapping("/allusers")
	public String allUser(HttpServletRequest request, HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");

		log.info("allusers");

		List<User> allUsers = userDao.query();

		request.setAttribute("allUsers", allUsers);

		return "allusers";
	}

}
