package org.zhe.framework.beans.factory;

import org.zhe.framework.beans.factory.exceptions.BeansException;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory
{
	<T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

	String[] getBeanDefinitionNames();
}
