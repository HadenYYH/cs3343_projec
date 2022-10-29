package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import Program.*;

class testRegister {
	
//As the original Register method in Account class output a message box, 
//it is hard to use assertEquals() to do testing. So we write a teststub
//to return a string for testing:
	class testStubAccount extends Account{
		
		private String name;
		private boolean loggedIn;
		
		private boolean validSid(String sid) {
			if((sid.length() == 8) & sid.matches("[0-9]+")) {
				return true;
			}
			return false;
		}
		
		public String testStubregister(String sid, String name, String email, String pw, String pw2) {
			SidandData sidandPw = SidandData.getInstance();

	    	boolean emailValid = email.endsWith("@my.cityu.edu.hk");
	    	boolean sidExist = sidandPw.containsKey(sid);
			boolean pwLongEnough = (pw.length() >= 8);
	    	boolean pwUpperCase = pw.matches(".*[A-Z].*");
	    	boolean pwLowerCase = pw.matches(".*[a-z].*");
	    	boolean pwSymbol = pw.matches(".*[^\\w].*");
	    	boolean pwNoComma = !pw.matches(".*[,].*");
	    	boolean pw2Correct = pw.equals(pw2);
	    	Services services = new Services();
	    	StringBuilder hashed_pw = new StringBuilder();
	    	ArrayList<String> file_list = services.getALLTextFileInDirectory();
	    	
	    	String fileExist = services.getUserDataBySid(sid);
	    	
	    	if (!validSid(sid)) {
	        	return "Invalid sid";
	        }
	    	else if(sidExist) {
	        	return "This SID was registered";
	    	}
	        else if (!emailValid) {
	        	return "Invalid email";
	        }
	        else if (!pwLongEnough) {
	        	return "Password must be longer than 8 chracters";
	        }
	        else if (!pwUpperCase) {
	        	return "Password must contain an upper case letter";
	        }
	        else if (!pwLowerCase) {
	        	return "Password must contain an lower case letter";
	        }
	        else if (!pwSymbol) {
	        	return "Password must contain a non-letter symbol";
	        }
	        else if (!pwNoComma) {
	        	return "Password must not contain a comma";
	        }
	        else if (!pw2Correct) {
	        	return "Two passwords are different";
	        }
	        else if(name.length()>15) {
	        	return "Username too long";
	        }
	        else if(services.checkEmail(email, file_list)){
	        	return "Email already used";
	        }
	        else if(fileExist!=null){
	        	return "SID already used";
	        }
	        else {
				try {
					hashed_pw = services.getHashPw(sid, pw);
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
	        	services.writeUserData(sid, name, email, hashed_pw);
	        	
	    		sidandPw.put(sid, name, email, pw);
	    		this.name = name;
	    		loggedIn = true;
	    		return "Register sucessfully";
	        }
		}
	}

	@Test
	void test001() {
		testStubAccount account = new testStubAccount();
		assertEquals("Register sucessfully", account.testStubregister("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
	}
	
	@Test
	void test002() {
		testStubAccount account = new testStubAccount();
		assertEquals("Password must contain a non-letter symbol", account.testStubregister("23456789", "Alex", "alex@my.cityu.edu.hk", "123456Ab", "123456Ab"));
	}
	
	@Test
	void test003() {
		testStubAccount account = new testStubAccount();
		assertEquals("Password must contain an lower case letter", account.testStubregister("23456789", "Alex", "alex@my.cityu.edu.hk", "123456A*", "123456A*"));
	}
	
	@Test
	void test004() {
		testStubAccount account = new testStubAccount();
		assertEquals("Password must contain an upper case letter", account.testStubregister("23456789", "Alex", "alex@my.cityu.edu.hk", "123456b*", "123456b*"));
	}
	
	@Test
	void test005() {
		testStubAccount account = new testStubAccount();
		assertEquals("Password must be at least 8 characters", account.testStubregister("23456789", "Alex", "alex@my.cityu.edu.hk", "1234Ab*", "1234Ab*"));
	}
	
	@Test
	void test006() {
		testStubAccount account = new testStubAccount();
		assertEquals("Invalid sid", account.testStubregister("1234567", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
	}
	
	@Test
	void test007() {
		testStubAccount account = new testStubAccount();
		assertEquals("Invalid sid", account.testStubregister("123456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
	}
	
	@Test
	void test008() {
		testStubAccount account = new testStubAccount();
		assertEquals("Invalid sid", account.testStubregister("1234567a", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
	}
	
	@Test
	void test009() {
		testStubAccount account = new testStubAccount();
		assertEquals("Invalid email", account.testStubregister("23456789", "Alex", "alex@gmail.com", "12345Ab*", "12345Ab*"));
	}
	
	@Test
	void test010() {
		testStubAccount account = new testStubAccount();
		assertEquals("Username too long", account.testStubregister("23456789", "AlexanderJohnson", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
	}
	
	@Test
	void test011() {
		testStubAccount account = new testStubAccount();
		assertEquals("Two passwords are different", account.testStubregister("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab**"));
	}
	
	@Test
	void test012() {
		testStubAccount account = new testStubAccount();
		assertEquals("Password must not contain a comma", account.testStubregister("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab,", "12345Ab,"));
	}
	
	@Test
	void test013() {
		testStubAccount account = new testStubAccount();
		assertEquals("Register successfully", account.testStubregister("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*ncosdbgigrbnsiubvibubslfibvoshdfnnrisudbvosdbcsdfbskdfbsidfebsdkjbsvihrssofvhfjej", "12345Ab*ncosdbgigrbnsiubvibubslfibvoshdfnnrisudbvosdbcsdfbskdfbsidfebsdkjbsvihrssofvhfjej"));
	}
	
	@Test
	void test014() {
		testStubAccount account = new testStubAccount();
		assertEquals("Email already used", account.testStubregister("23456789", "Alex", "alex@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
	}
	
	@Test
	void test015() {
		testStubAccount account = new testStubAccount();
		assertEquals("SID already used", account.testStubregister("23456789", "Alex", "alex2@my.cityu.edu.hk", "12345Ab*", "12345Ab*"));
	}

}
