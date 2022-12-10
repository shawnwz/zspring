package org.zhe.framework.beans;

public class BeanDefinition
{
	private Object bean;

	public BeanDefinition(Object bean)
	{
		this.bean = bean;
	}

	public Object getBean()
	{
		return bean;
	}
}
