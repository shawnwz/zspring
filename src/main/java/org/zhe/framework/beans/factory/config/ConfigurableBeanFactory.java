package org.zhe.framework.beans.factory.config;

import org.zhe.framework.beans.factory.HierarchicalBeanFactory;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRigistry
{
	String SCOPE_SINGLETON = "singleton";

	String SCOPE_PROTOTYPE = "prototype";
}
