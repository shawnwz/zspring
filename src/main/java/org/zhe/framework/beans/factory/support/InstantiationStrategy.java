package org.zhe.framework.beans.factory.support;

import org.zhe.framework.beans.factory.config.BeanDefinition;
import org.zhe.framework.beans.factory.exceptions.BeansException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy
{
	Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
