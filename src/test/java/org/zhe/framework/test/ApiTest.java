package org.zhe.framework.test;

import org.junit.Test;
import org.zhe.framework.beans.BeanDefinition;
import org.zhe.framework.beans.BeanFactory;
import org.zhe.framework.test.bean.UserService;


public class ApiTest
{
	@Test
	public void test_BeanFactory()
	{
		BeanFactory beanFactory = new BeanFactory();

		BeanDefinition beanDefinition = new BeanDefinition(new UserService());

		beanFactory.registerBeanDefinition("UserService", beanDefinition);

		UserService userService = (UserService) beanFactory.getBean("UserService");
		userService.queryUserInfo();
	}
}
