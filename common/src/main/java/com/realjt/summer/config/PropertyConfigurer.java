package com.realjt.summer.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyConfigurer extends PropertyPlaceholderConfigurer
{
	private Properties properties;

	@Override
	protected Properties mergeProperties() throws IOException
	{
		properties = super.mergeProperties();

		return properties;
	}

	public Properties getProperties()
	{
		return properties;
	}

}
