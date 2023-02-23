package org.zhe.framework.beans.factory.config;

import org.zhe.framework.beans.factory.BeanFactory;
import org.zhe.framework.beans.factory.exceptions.BeansException;

public interface AutowireCapableBeanFactory extends BeanFactory
{
	Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws
			BeansException;

	Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
