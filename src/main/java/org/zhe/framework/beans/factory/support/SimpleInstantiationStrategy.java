package org.zhe.framework.beans.factory.support;

import org.zhe.framework.beans.factory.config.BeanDefinition;
import org.zhe.framework.beans.factory.exceptions.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy
{
	@Override
	public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,
			Object[] args) throws BeansException
	{
		Class clazz = beanDefinition.getBeanClass();
		try{
			if (null!=ctor){
				return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
			}
			else{
				return clazz.getDeclaredConstructor().newInstance();
			}
		}
		catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
			throw new BeansException("Failed to instantiate "+ clazz.getName(), e);
		}
	}
}
