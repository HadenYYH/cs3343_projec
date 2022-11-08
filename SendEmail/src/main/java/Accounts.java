import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Accounts {
	private static Map<String, Account> accounts = new HashMap<String, Account>();
	private static Accounts instance = null;
	
    private Accounts(){
    	String sid = "12345678";
    	String name = "cs3343";
    	String email = "choulwu2-c@my.cityu.edu.hk";
    	String pw = "aA123456!";
    	accounts.put(sid, new Account(sid, name, email, pw));
    }
    
    public static Accounts getInstance(){
    	if (instance == null) {
            instance = new Accounts();
    	}
    	return instance;
    }
	
	private boolean validSid(String sid) {
		if((sid.length() == 8) & sid.matches("[0-9]+")) {
			return true;
		}
		return false;
	}

	private void message(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public boolean register(String sid, String name, String email, String pw, String pw2) {
    	boolean emailValid = email.endsWith("@my.cityu.edu.hk");
    	boolean sidExist = accounts.containsKey(sid);
		boolean pwLongEnough = (pw.length() >= 8);
    	boolean pwUpperCase = pw.matches(".*[A-Z].*");
    	boolean pwLowerCase = pw.matches(".*[a-z].*");
    	boolean pwSymbol = pw.matches(".*[^\\w].*");
    	boolean pwNoComma = !pw.matches(".*[,].*");
    	boolean pw2Correct = pw.equals(pw2);
    	
    	if (!validSid(sid)) {
        	message("Invalid sid");
        }
    	else if(sidExist) {
        	message("This SID was registered");
    	}
        else if(name.length()>15) {
        	message("Username too long");
        }
        else if (!emailValid) {
        	message("Invalid email");
        }
        else if (!pwLongEnough) {
        	message("Password must be longer than 8 chracters");
        }
        else if (!pwUpperCase) {
        	message("Password must contain an upper case letter");
        }
        else if (!pwLowerCase) {
        	message("Password must contain an lower case letter");
        }
        else if (!pwSymbol) {
        	message("Password must contain a non-letter symbol");
        }
        else if (!pwNoComma) {
        	message("Password must not contain a comma");
        }
        else if (!pw2Correct) {
        	message("Two passwords are different");
        }
        else {
        	Account user = new Account(sid, name, email, pw);
    		accounts.put(sid, user);
    		message("Register sucessfully");
    		return true;
        }
    	return false;
	}
	
	public Account login(String sid, String pw) {		
    	boolean sidExist = accounts.containsKey(sid);
    	
        if (!validSid(sid)) {
        	message("Invalid sid");
            return null;
        }
        else if (!sidExist) {
        	message("Wrong SID or password");
            return null;
        }
        Account account = accounts.get(sid);
        
        if (!pw.equals(account.getPw())) {
        	message("Wrong SID or password");
            return null;
        }
        else {
    		message("Login Sucessfully!");
    		return account;
        }
	}
	
	public boolean checkForget(String sid, String email) {    	
    	boolean sidExist = accounts.containsKey(sid);
    	
        if (!validSid(sid)) {
        	message("Invalid sid");
        	return false;
        }
        else if (!sidExist) {
        	message("Wrong SID or email");
        	return false;
        }
    	Account account = accounts.get(sid);
    	
        if (!email.equals(account.getEmail())) {
        	message("Wrong SID or email");
        	return false;
        }
        else {
        	RandomPw randomPw = RandomPw.getInstance();
        	String pw = randomPw.randomPw();

    		account.editPw(sid, account.getPw(), pw, pw);
        	
        	accounts.put(sid, account);
        	
        	SendEmail send = SendEmail.getInstance();
        	send.sendNewPw(account.getEmail(), pw);
        	message("A temporary password has been sent to your email\nPlease login again");
        	return true;
        }
	}
    
    public void put(String sid, Account account) {
    	accounts.put(sid, account);
    }
    
    public Account getAccount(String sid) {
		return accounts.get(sid);
	}

	public boolean containsKey(String sid) {
		return accounts.containsKey(sid);
	}
}
