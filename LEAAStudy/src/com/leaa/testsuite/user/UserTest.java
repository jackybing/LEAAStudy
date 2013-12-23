package com.leaa.testsuite.user;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leaa.model.address.Address;
import com.leaa.model.user.User;
import com.sun.org.apache.xpath.internal.Expression;

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
	
	@Ignore
	public void testCreateUser(){
		User user=new User();
		user.setName("john");
		user.setAge(20);
		session.save(user);
		
	}
	
	@Ignore
	public void testCreateAddress(){
		Address address=new Address();
		address.setDetail("beijing");
		
		session.save(address);
	}
	
	@Ignore
	public void testSetAddressForUser(){
		Address address=new Address();
		address.setDetail("beijing");
		User user=new User();
		user.setName("jackybing");
		user.setAge(30);
		user.setAddress(address);
		address.setUser(user);
		session.saveOrUpdate(user);
		session.saveOrUpdate(address);
	}
	
	@Ignore
	public void testGetAddressForUser(){
		User user=(User)session.load(User.class, 2);
		Address address=user.getAddress();
		Assert.assertNotNull(address);
	}
	
	@Test
	public void testModidyAddressForUser(){
		User user=(User)session.load(User.class,2);
		
		Address address=(Address)session.load(Address.class, 1);
		
		user.setAddress(address);
		session.update(user);
		session.flush();
	}
}
