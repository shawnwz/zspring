package org.zhe.framework.beans.factory.config;

public interface SingletonBeanRigistry
{
	Object getSingleton(String beanName);

	void registerSingleton(String beanName, Object singletonObject);
}
