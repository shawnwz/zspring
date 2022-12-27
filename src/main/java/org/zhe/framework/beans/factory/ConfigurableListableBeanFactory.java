package org.zhe.framework.beans.factory;

import org.zhe.framework.beans.factory.config.AutowireCapableBeanFactory;
import org.zhe.framework.beans.factory.config.BeanDefinition;
import org.zhe.framework.beans.factory.config.ConfigurableBeanFactory;
import org.zhe.framework.beans.factory.exceptions.BeansException;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory,
		AutowireCapableBeanFactory, ConfigurableBeanFactory
{
	BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
