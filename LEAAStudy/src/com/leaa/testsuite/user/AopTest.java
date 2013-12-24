package com.leaa.testsuite.user;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leaa.aop.aspect.BeanAspect;

public class AopTest {
	private static ApplicationContext ctx;
	private static BeanAspect beanAspect;
	
	@BeforeClass
	public static void setUp(){
		ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		beanAspect=(BeanAspect) ctx.getBean("beanAspect");
	}
	
	@AfterClass
	public static void destroy(){
		ctx=null;
		beanAspect=null;
	}
	
	@Test
	public void testAdvice(){
		beanAspect.sayHello("jackybing");
	}
}
