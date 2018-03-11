package com.realjt.summer.summer.dao.spi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;

import com.realjt.summer.summer.dao.UserDao;
import com.realjt.summer.summer.domain.User;

public class UserDaoSpi implements UserDao
{
	private static final Logger log = LoggerFactory.getLogger(UserDaoSpi.class);

	private static final RowMapper<User> USER_ROWMAPPER = new RowMapper<User>()
	{
		@Override
		public User mapRow(ResultSet resultSet, int i) throws SQLException
		{
			User user = new User();

			user.setId(resultSet.getInt("id"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setSex(resultSet.getInt("sex"));
			user.setAge(resultSet.getInt("age"));
			user.setPhone(resultSet.getString("phone"));
			user.setEmail(resultSet.getString("email"));
			user.setAddress(resultSet.getString("address"));

			return user;
		}

	};

	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(final User user)
	{
		if (null == user)
		{
			log.error("user is null");

			return;
		}

		String sql = "insert into userinfo (username,password,sex,age,phone,email,address) values (?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql, new PreparedStatementSetter()
		{
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException
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

	@Override
	public void add(final List<User> users)
	{
		if (CollectionUtils.isEmpty(users))
		{
			log.error("users is empty");

			return;
		}

		String sql = "insert into userinfo (username,password,sex,age,phone,email,address) values (?,?,?,?,?,?,?)";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
		{
			@Override
			public void setValues(PreparedStatement preparedStatement, int i) throws SQLException
			{
				preparedStatement.setString(1, users.get(i).getUsername());
				preparedStatement.setString(2, users.get(i).getPassword());
				preparedStatement.setInt(3, users.get(i).getSex());
				preparedStatement.setInt(4, users.get(i).getAge());
				preparedStatement.setString(5, users.get(i).getPhone());
				preparedStatement.setString(6, users.get(i).getEmail());
				preparedStatement.setString(7, users.get(i).getAddress());
			}

			@Override
			public int getBatchSize()
			{
				return users.size();
			}

		});
	}

	@Override
	public User query(int id)
	{
		String sql = "select * from userinfo where id = ?";

		User user = jdbcTemplate.queryForObject(sql, new Object[] { id }, USER_ROWMAPPER);

		return user;
	}

	@Override
	public User query(String username)
	{
		if (StringUtils.isBlank(username))
		{
			log.error("username is blank");

			return null;
		}

		String sql = "select * from userinfo where username = ?";

		User user = null;
		try
		{
			user = jdbcTemplate.queryForObject(sql, new Object[] { username }, USER_ROWMAPPER);
		} catch (EmptyResultDataAccessException e)
		{
			log.info("query with username = {}, result is empty", username);
		}

		return user;
	}

	@Override
	public List<User> query()
	{
		String sql = "select * from userinfo";

		List<User> users = jdbcTemplate.query(sql, USER_ROWMAPPER);

		return users;
	}

	@Override
	public void update(final User user)
	{
		if (null == user)
		{
			log.error("user is null");

			return;
		}

		String sql = "update userinfo set password = ?,sex = ?,age = ?,phone = ?,email = ?,address = ?";

		jdbcTemplate.update(sql, new PreparedStatementSetter()
		{
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException
			{
				preparedStatement.setString(1, user.getPassword());
				preparedStatement.setInt(2, user.getSex());
				preparedStatement.setInt(3, user.getAge());
				preparedStatement.setString(4, user.getPhone());
				preparedStatement.setString(5, user.getEmail());
				preparedStatement.setString(6, user.getAddress());
			}

		});
	}

	@Override
	public void delete(final int id)
	{
		String sql = "delete from userinfo where id = ?";

		jdbcTemplate.update(sql, new PreparedStatementSetter()
		{
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException
			{
				preparedStatement.setInt(1, id);
			}

		});
	}

	@Override
	public void delete(final String username)
	{
		String sql = "delete from userinfo where username = ?";

		jdbcTemplate.update(sql, new PreparedStatementSetter()
		{
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException
			{
				preparedStatement.setString(1, username);
			}

		});
	}

	@Override
	public long count()
	{
		String sql = "select count(*) from userinfo";

		return jdbcTemplate.queryForObject(sql, Long.class);
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