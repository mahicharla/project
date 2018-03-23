package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDetailDAO;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;

public class UserDetailDAOTest {
static UserDetailDAO userDetailDAO;
	
	@BeforeClass
	public static void preExecution() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
}

	@Ignore
	@Test
	public void addUserTest() {
		
		UserDetail userDetail=new UserDetail();
		userDetail.setAddress("kasaragod");
		userDetail.setCustomerName("jaya");
		userDetail.setEmailId("sandeep@gmail.com");
		userDetail.setEnabled(true);
		userDetail.setPassword("password456");
		userDetail.setRole("ADMIN");
		userDetail.setUsername("mamatha");
		
		assertTrue("Error in ading a user", userDetailDAO.addUser(userDetail));
		
	}
	@Ignore
	@Test 
	public void updateUserTest() {
		UserDetail userDetail=userDetailDAO.getUser("mahesh");
		userDetail.setPassword("password4982");
		assertTrue("Error in updating user details",userDetailDAO.updateUser(userDetail));
	}
	@Ignore
	@Test
	public void deleteUserTest() {
		UserDetail userDetail=userDetailDAO.getUser("dayanada");
		assertTrue("Error in deleting user", userDetailDAO.deleteUser(userDetail));
	}
	//@Ignore
	@Test
	public void listUsersTest() {
		List<UserDetail> list =userDetailDAO.listUsers();
		for(UserDetail listuser:list) {
			System.out.println(listuser.getUsername()+"\t"+listuser.getAddress()
			+"\t\t\t"+listuser.getPassword()+"\t\t"+listuser.getRole());
		}
		assertNotNull("Error in listing all users",userDetailDAO.listUsers());
	}
}
