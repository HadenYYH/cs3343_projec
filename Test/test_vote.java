package Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Program.Accounts;
import Program.Topic;
import Program.Topics;
import Program.Account;

public class test_vote {

	@Test
	void test037() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		Topic topic = new Topic("23456789", a, "test", "test_description");
		Topics topics = Topics.getInstance();
		assertEquals("Agree successfully", topic.vote(a));
		topics.remove(topic);
	}
	
	@Test
	void test038() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		Topic topic = new Topic("23456789", a, "test", "test_description");
		Topics topics = Topics.getInstance();
		assertEquals("Disagree successfully", topic.vote(a));
		topics.remove(topic);
	}
	
	@Test
	void test039() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		Topic topic = new Topic("23456789", a, "test", "test_description");
		Topics topics = Topics.getInstance();
		topic.vote(a);
		assertEquals("You have already agreed on this topic", topic.vote(a));
		topics.remove(topic);
	}
	
	@Test
	void test040() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		Topic topic = new Topic("23456789", a, "test", "test_description");
		Topics topics = Topics.getInstance();
		topic.vote(a);
		assertEquals("You have already disagreed on this topic", topic.vote(a));
		topics.remove(topic);
	}
	
	@Test
	void test041() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		Topic topic = new Topic("23456789", a, "test", "test_description");
		Topics topics = Topics.getInstance();
		topic.vote(a);
		assertEquals("Agree successfully", topic.vote(a));
		topics.remove(topic);
	}
	
	@Test
	void test042() {
		Accounts accounts = Accounts.getInstance();
		accounts.register("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*");
		Account a = accounts.getAccount("23456789"); 
		Topic topic = new Topic("23456789", a, "test", "test_description");
		Topics topics = Topics.getInstance();
		topic.vote(a);
		assertEquals("Disagree successfully", topic.vote(a));
		topics.remove(topic);
	}
}
