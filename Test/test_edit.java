package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Program.Accounts;
import Program.Account;


public class test_edit {
	@Test
	void test019() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Edit successfully", a.edit("23456789", "Ben", "alex@my.cityu.edu.hk", "12345Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test020() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Invalid sid", a.edit("234567891", "Ben", "alex@my.cityu.edu.hk", "12345Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test021() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		accounts.register("34567891", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("This SID was registered", a.edit("34567891", "Ben", "alex@my.cityu.edu.hk", "12345Ab*"));
		accounts.remove("23456789");
		accounts.remove("34567891");
	}
	
	@Test
	void test022() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Invalid email", a.edit("34567891", "Ben", "alex@gmail.com", "12345Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test023() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Username too long", a.edit("34567891", "AlexanderJohnson", "alex@my.cityu.edu.hk", "12345Ab*"));
		accounts.remove("23456789");
	}
	
	@Test
	void test024() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		assertEquals("Wrong password", a.edit("23456789", "Ben", "alex@my.cityu.edu.hk", "12345Ac*"));
		accounts.remove("23456789");
	}

}

