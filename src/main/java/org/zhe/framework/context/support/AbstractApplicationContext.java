package org.zhe.framework.context.support;

import org.zhe.framework.beans.factory.ConfigurableListableBeanFactory;
import org.zhe.framework.beans.factory.config.BeanFactoryPostProcessor;
import org.zhe.framework.beans.factory.config.BeanPostProcessor;
import org.zhe.framework.beans.factory.exceptions.BeansException;
import org.zhe.framework.context.ConfigurableApplicationContext;
import org.zhe.framework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * Abstract implementation of the {@link org.zhe.framework.context.ApplicationContext}
 * interface. Doesn't mandate the type of storage used for configuration; simply
 * implements common context functionality. Uses the Template Method design pattern,
 * requiring concrete subclasses to implement abstract methods.
 * <p>
 * abstract application context
 * <p>
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements
		ConfigurableApplicationContext
{
	@Override
	public void refresh() throws BeansException
	{
		// 1. Create BeanFactory，and load BeanDefinition
		refreshBeanFactory();

		// 2. Get BeanFactory
		ConfigurableListableBeanFactory beanFactory = getBeanFactory();

		// 3. Before Bean init，execute BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
		invokeBeanFactoryPostProcessors(beanFactory);

		// 4. BeanPostProcessor
		registerBeanPostProcessors(beanFactory);

		// 5. init singletions bean object
		beanFactory.preInstantiateSingletons();
	}

	protected abstract void refreshBeanFactory() throws BeansException;

	protected abstract ConfigurableListableBeanFactory getBeanFactory();

	private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
		Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
		for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
			beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
		}
	}

	private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
		Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
		for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
			beanFactory.addBeanPostProcessor(beanPostProcessor);
		}
	}

	@Override
	public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
		return getBeanFactory().getBeansOfType(type);
	}

	@Override
	public String[] getBeanDefinitionNames() {
		return getBeanFactory().getBeanDefinitionNames();
	}

	@Override
	public Object getBean(String name) throws BeansException {
		return getBeanFactory().getBean(name);
	}

	@Override
	public Object getBean(String name, Object... args) throws BeansException {
		return getBeanFactory().getBean(name, args);
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return getBeanFactory().getBean(name, requiredType);
	}
}
