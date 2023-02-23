package org.zhe.framework.beans.factory.config;

import org.zhe.framework.beans.factory.ConfigurableListableBeanFactory;
import org.zhe.framework.beans.factory.exceptions.BeansException;

public interface BeanFactoryPostProcessor
{
	/**
	 * after all BeanDefinition loaded，before init Bean object，provide a way to modify BeanDefinition
	 *
	 * @param beanFactory
	 * @throws BeansException
	 */
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
