package org.zhe.framework.beans.factory.support;

import org.zhe.framework.beans.factory.config.BeanDefinition;
import org.zhe.framework.beans.factory.exceptions.BeansException;

public interface BeanDefinitionRegistry
{
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

	BeanDefinition getBeanDefinition(String beanName) throws BeansException;

	boolean containsBeanDefinition(String beanName);

	String[] getBeanDefinitionNames();
}
