package org.zhe.framework.beans.factory.config;

import org.zhe.framework.beans.factory.exceptions.BeansException;

public interface BeanPostProcessor
{

	Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

	Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
