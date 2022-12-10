package org.zhe.framework.beans.factory.support;

import org.zhe.framework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry
{
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
