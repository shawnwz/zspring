package org.zhe.framework.beans.factory.exceptions;

public class BeansException extends RuntimeException
{
	public BeansException(String msg) {
		super(msg);
	}

	public BeansException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
