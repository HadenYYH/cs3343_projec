package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Program.Accounts;
import Program.Account;

public class test_checkForgot {
	
	@Test
	void test033() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("A temporary password has been sent to your email\nPlease login again", accounts.checkForget("23456789", "alex@my.cityu.edu.hk"));
		accounts.remove("23456789");
	}
	
	@Test
	void test034() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Invalid sid", accounts.checkForget("2345678", "alex@my.cityu.edu.hk"));
		accounts.remove("23456789");
	}
	
	@Test
	void test035() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Wrong SID or email", accounts.checkForget("23456781", "alex@my.cityu.edu.hk"));
		accounts.remove("23456789");
	}
	
	@Test
	void test036() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Wrong SID or email", accounts.checkForget("23456789", "ben@my.cityu.edu.hk"));
		accounts.remove("23456789");
	}
	
}
