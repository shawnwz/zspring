package org.zhe.framework.context;


import org.zhe.framework.beans.factory.exceptions.BeansException;

/**
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the
 * {@link ApplicationContext} interface.
 */
public interface ConfigurableApplicationContext extends ApplicationContext
{
	/**
	 * refresh container
	 *
	 * @throws BeansException
	 */
	void refresh() throws BeansException;
}
