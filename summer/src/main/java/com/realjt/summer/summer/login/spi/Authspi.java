package com.realjt.summer.summer.login.spi;

import com.realjt.summer.summer.dao.UserDao;
import com.realjt.summer.summer.login.Auth;

/**
 * Created by lettry on 2017/6/29.
 */
public class Authspi implements Auth
{
	UserDao userDao;

	@Override
	public boolean auth(String name, String passwd)
	{

		// User user = userDao.query(name);
		// if (user != null && StringUtils.equals(user.getPassword(), passwd))
		// {
		// return true;
		// }
		return false;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

}
