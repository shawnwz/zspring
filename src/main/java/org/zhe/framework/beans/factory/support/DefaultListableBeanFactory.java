package org.zhe.framework.beans.factory.support;

import org.zhe.framework.beans.factory.config.BeanDefinition;
import org.zhe.framework.beans.factory.exceptions.BeansException;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry
{

	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

	@Override
	protected BeanDefinition getBeanDefinition(String beanName) throws BeansException
	{
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (beanDefinition == null)
		{
			throw new BeansException("No bean named " + beanName + "is defined");
		}
		return beanDefinition;
	}

	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
	{
		beanDefinitionMap.put(beanName, beanDefinition);
	}

}
