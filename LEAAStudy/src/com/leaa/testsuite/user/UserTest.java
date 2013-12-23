package com.leaa.testsuite.user;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leaa.model.user.User;

public class UserTest {
	private static ApplicationContext ctx;
	private static Session session;
	
	@BeforeClass
	public static void setUp(){
		ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		session=((SessionFactory) ctx.getBean("sessionFactory")).openSession();
	}
	
	@AfterClass
	public static void destroy(){
		ctx=null;
		session.close();
	}
	
	@Test
	public void testCreateUser(){
		User user=new User();
		user.setName("jackybing");
		user.setAge(30);
		session.save(user);
		
	}
}
