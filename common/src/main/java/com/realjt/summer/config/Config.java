package com.realjt.summer.config;

import javax.servlet.ServletContext;

public class Config
{
	private static Config config = new Config();

	private static PropertyConfigurer propertyConfigurer;

	public static final String TOMCAT_PATH = "tomcat.path";

	public static final String APPLICATION_NAME = "application.name";

	public static final String APPLICATION_PATH = "application.path";

	private Config()
	{
	}

	public static Config getInstance(PropertyConfigurer propertyConfigurer, ServletContext servletContext)
	{
		Config.propertyConfigurer = propertyConfigurer;

		Config.propertyConfigurer.getProperties().setProperty(TOMCAT_PATH, System.getProperty("catalina.home"));
		Config.propertyConfigurer.getProperties().setProperty(APPLICATION_NAME,
				servletContext.getContextPath().replace("/", ""));
		Config.propertyConfigurer.getProperties().setProperty(APPLICATION_PATH,
				servletContext.getRealPath("").substring(0, servletContext.getRealPath("").length() - 1));

		return config;
	}

	public static String getString(String key)
	{
		return propertyConfigurer.getProperties().getProperty(key);
	}

	public static String getString(String key, String defaultValue)
	{
		return propertyConfigurer.getProperties().getProperty(key, defaultValue);
	}

	public static int getInt(String key)
	{
		return Integer.valueOf(propertyConfigurer.getProperties().getProperty(key));
	}

	public static int getInt(String key, String defaultValue)
	{
		return Integer.valueOf(propertyConfigurer.getProperties().getProperty(key, defaultValue));
	}

}
