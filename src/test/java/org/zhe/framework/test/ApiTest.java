package org.zhe.framework.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;
import org.zhe.framework.beans.factory.config.BeanDefinition;
import org.zhe.framework.beans.factory.support.DefaultListableBeanFactory;
import org.zhe.framework.test.bean.UserService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class ApiTest
{
	@Test
	public void test_BeanFactory()
	{
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

		beanFactory.registerBeanDefinition("userService", beanDefinition);

		UserService userService = (UserService) beanFactory.getBean("userService", "My Name");
		userService.queryUserInfo();
	}

	@Test
	public void test_newInstance() throws IllegalAccessException, InstantiationException
	{
		UserService userService = UserService.class.newInstance();
		System.out.println(userService);
	}

	@Test
	public void test_cglib()
	{
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserService.class);
		enhancer.setCallback(
				new NoOp() {
					@Override
					public int hashCode() {
						return super.hashCode();
					}
				}
		);
		Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"My Name"});
		System.out.println(obj);
	}

	@Test
	public void test_constructor() throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException
	{
		Class<UserService> userServiceClass = UserService.class;
		Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
		UserService userService = declaredConstructor.newInstance("My Name");
		System.out.println(userService);
	}

	@Test
	public void test_parameterTypes() throws Exception
	{
		Class<UserService> beanClass = UserService.class;
		Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
		Constructor<?> constructor = null;
		for (Constructor<?> ctor : declaredConstructors)
		{
			if(ctor.getParameterTypes().length == 1)
			{
				constructor = ctor;
				break;
			}
		}
		Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
		UserService userService = declaredConstructor.newInstance("My Name");
		System.out.println(userService);
	}
}
