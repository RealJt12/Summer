package com.realjt.summer.summer.dao;

import java.util.List;

import com.realjt.summer.summer.domain.User;

public interface UserDao
{
	/**
	 * 新增user
	 * 
	 * @param user
	 */
	void add(User user);

	/**
	 * 批量新增user
	 * 
	 * @param users
	 */
	void add(List<User> users);

	/**
	 * 按id查询
	 * 
	 * @param id
	 * @return
	 */
	User query(int id);

	/**
	 * 按username查询
	 * 
	 * @param username
	 * @return
	 */
	User query(String username);

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	List<User> query();

	/**
	 * 修改user
	 * 
	 * @param user
	 */
	void update(User user);

	/**
	 * 按id删除
	 * 
	 * @param id
	 */
	void delete(int id);

	/**
	 * 按username删除
	 * 
	 * @param username
	 */
	void delete(String username);

	/**
	 * 统计user数量
	 * 
	 * @return
	 */
	long count();
}