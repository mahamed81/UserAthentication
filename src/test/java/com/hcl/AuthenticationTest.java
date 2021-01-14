package com.hcl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hcl.model.User;


public class AuthenticationTest {
	
	@BeforeEach
	public void setup() {
		
		User user = new User();
		Authentication.userList.add(new User("Altaf", "pass", "Admin"));
		Authentication.userList.add(new User("Ali", "pass", "Dev"));
		Authentication.userList.add(new User("John", "pass", "Data Analys"));
		Authentication.userList.add(new User("Khalid", "pass", "Advisor"));
	}
	
	@Test
	public void testLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "pass"));
	}
	
	@Test
	public void testWrongUserLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(false, authentication.login("Jake", "pass"));
	}

	@Test
	public void testUserAssert() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Jhon", "pass"));
		
		assertEquals("John", authentication.getUserName());
	}
	
	@Test
	public void testRoleAssert() {
		Authentication authentication = new Authentication();
		
		assertEquals(false, authentication.login("Ali", "pass"));
		
		assertEquals("Dev", authentication.getRole());
	}

	@Test
	public void testLogout() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Khalid", "pass"));
		
		authentication.logout();
		
		assertEquals(null, authentication.getRole());
	}
	

}