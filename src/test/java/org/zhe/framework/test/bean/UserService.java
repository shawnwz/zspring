package org.zhe.framework.test.bean;

public class UserService
{
	private String id;
	private UserDao userDao;

	public void queryUserInfo()
	{
		System.out.println("Query User Info...:" + userDao.queryUserName(id));
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public UserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
}
