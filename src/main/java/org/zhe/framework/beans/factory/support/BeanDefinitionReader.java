package org.zhe.framework.beans.factory.support;

import org.zhe.framework.beans.factory.exceptions.BeansException;
import org.zhe.framework.core.io.Resource;
import org.zhe.framework.core.io.ResourceLoader;

public interface BeanDefinitionReader
{
	BeanDefinitionRegistry getRegistry();

	ResourceLoader getResourceLoader();

	void loadBeanDefinitions(Resource resource) throws BeansException;

	void loadBeanDefinitions(Resource... resources) throws BeansException;

	void loadBeanDefinitions(String location) throws BeansException;

	void loadBeanDefinitions(String... locations) throws BeansException;
}
