package com.realjt.summer.summer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SummerServlet extends HttpServlet
{
	private static final long serialVersionUID = -3903640785697216419L;

	private static final Logger log = LoggerFactory
			.getLogger(SummerServlet.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");

		log.info("abc");
		log.debug("realjt");

		response.getWriter().write("developer");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
	}

}