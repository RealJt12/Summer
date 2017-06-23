package com.realjt.summer.summer.dao;

import com.realjt.summer.summer.domain.User;

public interface UserDao
{
	void insertUser(User user);

	User queryUser(int id);
}