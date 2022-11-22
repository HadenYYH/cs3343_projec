package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Program.*;

class test_register {
	
//As the original Register method in Account class output a message box, 
//it is hard to use assertEquals() to do testing. So we write a teststub
//to return a string for testing:
	

	@Test
	void test001() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Register successfully", accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test002() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Password must contain a non-letter symbol", accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "123456Ab", "123456Ab"));
		accounts.remove("23456789");
	}
	
	@Test
	void test003() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Password must contain an lower case letter", accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "123456A*", "123456A*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test004() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Password must contain an upper case letter", accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "123456b*", "123456b*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test005() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Password must be at least 8 characters", accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "1234Ab*", "1234Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test006() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Invalid sid", accounts.register("1234567", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test007() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Invalid sid", accounts.register("123456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test008() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Invalid sid", accounts.register("1234567a", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test009() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Invalid email", accounts.register("23456789", "Alex", "alex@gmail.com", "12345Ab*", "12345Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test010() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Username too long", accounts.register("23456789", "AlexanderJohnson", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test011() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Two passwords are different", accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab**"));
		accounts.remove("23456789");
	}
	
	@Test
	void test012() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Password must not contain a comma", accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab,", "12345Ab,"));
		accounts.remove("23456789");
	}
	
	@Test
	void test013() {
		Accounts accounts = Accounts.getInstance();
		assertEquals("Register successfully", accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*ncosdbgigrbnsiubvibubslfibvoshdfnnrisudbvosdbcsdfbskdfbsidfebsdkjbsvihrssofvhfjej", "12345Ab*ncosdbgigrbnsiubvibubslfibvoshdfnnrisudbvosdbcsdfbskdfbsidfebsdkjbsvihrssofvhfjej"));
		accounts.remove("23456789");
	}
	
	@Test
	void test014() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		assertEquals("This SID was registered", accounts.register("23456789", "Alex", "alex2@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
		accounts.remove("23456789");
	}

}


