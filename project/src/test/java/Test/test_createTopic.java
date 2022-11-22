package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Program.Accounts;
import Program.Topics;
import Program.Account;

public class test_createTopic {

	@Test
	void test048() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789");
		Topics topics = Topics.getInstance();
		assertEquals("Topic created\n id: 00000001", topics.createTopic(a, "test", "test_description"));
		accounts.remove("23456789");
		topics.remove(topics.getTopic("00000001"));
	}
	
	@Test
	void test049() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789");
		Topics topics = Topics.getInstance();
		assertEquals("Please input topic name", topics.createTopic(a, "", "test_description"));
		accounts.remove("23456789");
	}
	
	@Test
	void test050() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789");
		Topics topics = Topics.getInstance();
		assertEquals("Please input topic description", topics.createTopic(a, "test", ""));
		accounts.remove("23456789");
	}
}