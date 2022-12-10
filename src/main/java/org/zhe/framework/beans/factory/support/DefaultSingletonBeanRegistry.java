package org.zhe.framework.beans.factory.support;

import org.zhe.framework.beans.factory.config.SingletonBeanRigistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRigistry
{
	private Map<String, Object> singletonObjects = new HashMap<>();

	@Override
	public Object getSingleton(String beanName)
	{
		return singletonObjects.get(beanName);
	}

	@Override
	public void registerSingleton(String beanName, Object singletonObject)
	{
		singletonObjects.put(beanName, singletonObject);
	}
}
