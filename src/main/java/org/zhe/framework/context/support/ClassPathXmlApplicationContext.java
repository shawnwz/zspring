package org.zhe.framework.context.support;

import org.zhe.framework.beans.factory.exceptions.BeansException;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext
{
	private String[] configLocations;

	public ClassPathXmlApplicationContext() {
	}

	/**
	 *  load BeanDefinition from XML, and refresh context
	 *
	 * @param configLocations
	 * @throws BeansException
	 */
	public ClassPathXmlApplicationContext(String configLocations) throws BeansException
	{
		this(new String[]{configLocations});
	}

	/**
	 * load BeanDefinition from XML, and refresh context
	 * @param configLocations
	 * @throws BeansException
	 */
	public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
		this.configLocations = configLocations;
		refresh();
	}

	@Override
	protected String[] getConfigLocations() {
		return configLocations;
	}
}
