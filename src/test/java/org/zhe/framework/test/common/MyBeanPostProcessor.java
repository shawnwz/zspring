package org.zhe.framework.test.common;

import org.zhe.framework.beans.factory.config.BeanPostProcessor;
import org.zhe.framework.beans.factory.exceptions.BeansException;
import org.zhe.framework.test.bean.UserService;

public class MyBeanPostProcessor implements BeanPostProcessor
{
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
	{
		if ("userService".equals(beanName)) {
			UserService userService = (UserService) bean;
			userService.setLocation("Changed to: Beijing");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
