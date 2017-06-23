package com.realjt.summer.summer.dao.spi;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.realjt.summer.summer.dao.UserDao;
import com.realjt.summer.summer.domain.User;

public class UserDaoSpi implements UserDao
{
	private static final Logger log = LoggerFactory.getLogger(UserDaoSpi.class);

	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertUser(User user)
	{
		if (null == user)
		{
			log.error("user is null");
		}

		String sql = "insert into userinfo (username,password,sex,age,phone,email,address) values (?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql, new PreparedStatementSetter()
		{
			@Override
			public void setValues(PreparedStatement preparedStatement)
					throws SQLException
			{
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setInt(3, user.getSex());
				preparedStatement.setInt(4, user.getAge());
				preparedStatement.setString(5, user.getPhone());
				preparedStatement.setString(6, user.getEmail());
				preparedStatement.setString(7, user.getAddress());
			}

		});
	}

	public User queryUser(int id)
	{
		return null;
	}

	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

}