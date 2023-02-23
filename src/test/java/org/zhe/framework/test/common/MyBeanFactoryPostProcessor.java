package org.zhe.framework.test.common;

import org.zhe.framework.beans.PropertyValue;
import org.zhe.framework.beans.PropertyValues;
import org.zhe.framework.beans.factory.ConfigurableListableBeanFactory;
import org.zhe.framework.beans.factory.config.BeanDefinition;
import org.zhe.framework.beans.factory.config.BeanFactoryPostProcessor;
import org.zhe.framework.beans.factory.exceptions.BeansException;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor
{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws
			BeansException
	{

		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
		PropertyValues propertyValues = beanDefinition.getPropertyValues();

		propertyValues.addPropertyValue(new PropertyValue("company", "changed to: MyCompany"));
	}
}
