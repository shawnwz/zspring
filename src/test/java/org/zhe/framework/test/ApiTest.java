package org.zhe.framework.test;

import org.junit.Test;
import org.zhe.framework.beans.factory.config.BeanDefinition;
import org.zhe.framework.beans.factory.support.DefaultListableBeanFactory;
import org.zhe.framework.test.bean.UserService;


public class ApiTest
{
	@Test
	public void test_BeanFactory()
	{
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

		beanFactory.registerBeanDefinition("userService", beanDefinition);

		UserService userService = (UserService) beanFactory.getBean("userService", "My Name");
		userService.queryUserInfo();
	}
}
