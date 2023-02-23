package org.zhe.framework.test;

import cn.hutool.core.io.IoUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Before;
import org.junit.Test;
import org.zhe.framework.beans.PropertyValue;
import org.zhe.framework.beans.PropertyValues;
import org.zhe.framework.beans.factory.config.BeanDefinition;
import org.zhe.framework.beans.factory.config.BeanReference;
import org.zhe.framework.beans.factory.support.DefaultListableBeanFactory;
import org.zhe.framework.beans.factory.xml.XmlBeanDefinitionReader;
import org.zhe.framework.context.support.ClassPathXmlApplicationContext;
import org.zhe.framework.core.io.DefaultResourceLoader;
import org.zhe.framework.core.io.Resource;
import org.zhe.framework.test.bean.UserDao;
import org.zhe.framework.test.bean.UserService;
import org.zhe.framework.test.common.MyBeanFactoryPostProcessor;
import org.zhe.framework.test.common.MyBeanPostProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class ApiTest
{
	@Test
	public void test_BeanFactory() {
		// 1.init BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 2. UserDao registry
		beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

		// 3. UserService set property[uId、userDao]
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
		propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

		// 4. UserService inject bean
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
		beanFactory.registerBeanDefinition("userService", beanDefinition);

		// 5. UserService get bean
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUserInfo();
	}

	private DefaultResourceLoader resourceLoader;

	@Before
	public void init() {
		resourceLoader = new DefaultResourceLoader();
	}

	@Test
	public void test_classpath() throws IOException
	{
		Resource resource = resourceLoader.getResource("classpath:important.properties");
		InputStream inputStream = resource.getInputStream();
		String content = IoUtil.readUtf8(inputStream);
		System.out.println(content);
	}

	@Test
	public void test_file() throws IOException {
		Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
		InputStream inputStream = resource.getInputStream();
		String content = IoUtil.readUtf8(inputStream);
		System.out.println(content);
	}


	@Test
	public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
		// 1.初始化 BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 2. 读取配置文件&注册Bean
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions("classpath:spring.xml");

		// 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
		MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
		beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

		// 4. Bean实例化之后，修改 Bean 属性信息
		MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
		beanFactory.addBeanPostProcessor(beanPostProcessor);

		// 5. 获取Bean对象调用方法
		UserService userService = beanFactory.getBean("userService", UserService.class);
		String result = userService.queryUserInfo();
		System.out.println("测试结果：" + result);
	}

	@Test
	public void test_xml() {
		// 1.init BeanFactory
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

		// 2. get Bean object, invoke method
		UserService userService = applicationContext.getBean("userService", UserService.class);
		String result = userService.queryUserInfo();
		System.out.println("测试结果：" + result);
	}

}
