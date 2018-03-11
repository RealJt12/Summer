package com.realjt.summer.summer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, HttpServletResponse response)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int sex = Integer.valueOf(request.getParameter("sex"));
		int age = Integer.valueOf(request.getParameter("age"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		User queryUser = userDao.query(username);
		if (null != queryUser)
		{
			request.setAttribute("message", "the user " + username + " has already exist.");

			return "adduser";
		}

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

		return "redirect:/allusers";
	}

	@RequestMapping("/deleteuser")
	public String deleteUser(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("id");
		log.info("delete user id = " + id);

		if (StringUtils.isNoneBlank(id))
		{
			userDao.delete(Integer.valueOf(id));
		}

		return "redirect:/allusers";
	}

	@RequestMapping("/updateuser")
	public String updateUser(HttpServletRequest request, HttpServletResponse response)
	{
		return "redirect:/allusers";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response)
	{
		String inputValidateCode = request.getParameter("validateCode");

		HttpSession httpSession = request.getSession();
		String sesseionValidateCode = (String) httpSession.getAttribute("VALIDATE_CODE");

		if (StringUtils.isNoneBlank(inputValidateCode) && inputValidateCode.equalsIgnoreCase(sesseionValidateCode))
		{
			httpSession.setAttribute("loginMessage", "验证码正确");
		} else
		{
			httpSession.setAttribute("loginMessage", "验证码错误");
		}

		return "redirect:/jsp/login.jsp";
	}

}
