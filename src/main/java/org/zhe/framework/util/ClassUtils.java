package org.zhe.framework.util;

import cn.hutool.core.util.ClassUtil;

public class ClassUtils
{
	public static ClassLoader getDefaultClassLoader(){
		ClassLoader cl = null;
		try{
			cl = Thread.currentThread().getContextClassLoader();
		}
		catch (Throwable ex) {

		}
		if(cl == null){
			cl = ClassUtil.class.getClassLoader();
		}
		return cl;
	}
}
