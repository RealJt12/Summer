package com.realjt.summer.summer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class DeleteUserServlet extends HttpServlet
{
	private static final long serialVersionUID = 3999757855515550006L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		if (StringUtils.isNoneBlank(id))
		{
			response.getWriter().write("id=" + id);
		}
		response.sendRedirect("/summer/allusersservlet");
	}

}