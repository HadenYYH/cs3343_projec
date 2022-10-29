package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import Program.*;

class testLogin {
	
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
		
		public String testStublogin(String sid, String pw) throws NoSuchAlgorithmException {
			SidandData sidandPw = SidandData.getInstance();
	    	Services services = new Services();
	    	
	        if (!validSid(sid)) {
	        	return "Invalid sid";
	        }
	        else {
	        	String user_data = services.getUserDataBySid(sid);
		        if(user_data!=null) {
		        	String user_data_array [];
			        user_data_array = user_data.split(",");
			        StringBuilder encrypted_pw = services.getHashPw(sid, pw);
		        	if (encrypted_pw.toString().equals(user_data_array[3])) {
		        		loggedIn = true;
		        		return "Login Sucessfully!";
			        }else {
			        	return "Wrong SID or password";
		        	}
		        }else {
		        	return "Wrong SID or password";
		        }
	        }
	        
		}
	}

	@Test
	void test016() throws NoSuchAlgorithmException {
		testStubAccount account = new testStubAccount();
		assertEquals("Login Sucessfully!", account.testStublogin("23456789", "12345Ab*"));
	}
	
	@Test
	void test017() throws NoSuchAlgorithmException {
		testStubAccount account = new testStubAccount();
		assertEquals("Wrong SID or password", account.testStublogin("12345678", "12345Ab*"));
	}
	
	@Test
	void test018() throws NoSuchAlgorithmException {
		testStubAccount account = new testStubAccount();
		assertEquals("Wrong SID or password", account.testStublogin("23456789", "12345Ac*"));
	}


}
