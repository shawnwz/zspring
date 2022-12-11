package org.zhe.framework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao
{
	private static Map<String, String> hashMap = new HashMap<>();

	static {
		hashMap.put("001", "The First Name");
		hashMap.put("002", "The Second Name");
		hashMap.put("003", "The Third Name");
	}

	public String queryUserName(String id)
	{
		return hashMap.get(id);
	}
}
