package org.zhe.framework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao
{
	private static Map<String, String> hashMap = new HashMap<>();

	static {
		hashMap.put("10001", "001 Name");
		hashMap.put("10002", "002 Name");
		hashMap.put("10003", "003 Name");
	}

	public String queryUserName(String id)
	{
		return hashMap.get(id);
	}
}
