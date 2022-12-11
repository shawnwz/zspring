package org.zhe.framework.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;
import org.zhe.framework.beans.PropertyValue;
import org.zhe.framework.beans.PropertyValues;
import org.zhe.framework.beans.factory.config.BeanDefinition;
import org.zhe.framework.beans.factory.config.BeanReference;
import org.zhe.framework.beans.factory.support.DefaultListableBeanFactory;
import org.zhe.framework.test.bean.UserDao;
import org.zhe.framework.test.bean.UserService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class ApiTest
{
	@Test
	public void test_BeanFactory() {
		// 1.init BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 2. UserDao registry
		beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

		// 3. UserService set property[uId、userDao]
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("id", "001"));
		propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

		// 4. UserService inject bean
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
		beanFactory.registerBeanDefinition("userService", beanDefinition);

		// 5. UserService get bean
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUserInfo();
	}

	@Test
	public void test_newInstance() throws IllegalAccessException, InstantiationException
	{
		UserService userService = UserService.class.newInstance();
		System.out.println(userService);
	}

}
