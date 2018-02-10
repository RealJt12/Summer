package com.realjt.summer.config;

public class Config
{
	private static Config config = new Config();

	private static PropertyConfigurer propertyConfigurer;

	private Config()
	{
	}

	public static Config getInstance(PropertyConfigurer propertyConfigurer)
	{
		Config.propertyConfigurer = propertyConfigurer;

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
