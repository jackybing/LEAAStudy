package com.leaa.aop.advice;

public class BeanAdvice {
	public void authority(){
		System.out.println("开始执行sayHello()方法");
	}
	
	public void release(){
		System.out.println("sayHello()方法执行完毕");
	}
}
