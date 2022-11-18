package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Program.Accounts;
import Program.Account;

public class test_editPw {
	@Test
	void test025() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Password Changed", a.editPw("23456789", "12345Ab*", "12345Ac*", "12345Ac*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test026() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Wrong password", a.editPw("23456789", "12345Ac*", "12345Ac*", "12345Ac*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test027() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Password must contain at least 8 characters", a.editPw("23456789", "12345Ab*", "12345Ac", "12345Ac"));
		accounts.remove("23456789");
	}
	
	@Test
	void test028() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Password must contain an upper case letter", a.editPw("23456789", "12345Ab*", "12345ac*", "12345ac*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test029() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Password must contain an lower case letter", a.editPw("23456789", "12345Ab*", "12345AC*", "12345AC*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test030() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Password must contain a non-letter symbol", a.editPw("23456789", "12345Ab*", "12345Acb", "12345Acb"));
		accounts.remove("23456789");
	}
	
	@Test
	void test031() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Password must not contain a comma", a.editPw("23456789", "12345Ab*", "12345Ac*,", "12345Ac*,"));
		accounts.remove("23456789");
	}
	
	@Test
	void test032() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Two passwords are different", a.editPw("23456789", "12345Ab*", "12345Ac*", "12345Ab*"));
		accounts.remove("23456789");
	}
}

