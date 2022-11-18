package Program;
import java.util.HashMap;
import java.util.Map;

public class Accounts {
	private static Map<String, Account> accounts = new HashMap<String, Account>();
	private static Accounts instance = null;
	
    protected Accounts(){
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
	
	public String register(String sid, String name, String email, String pw, String pw2) {
    	boolean emailValid = email.endsWith("@my.cityu.edu.hk");
    	boolean sidExist = accounts.containsKey(sid);
		boolean pwLongEnough = (pw.length() >= 8);
    	boolean pwUpperCase = pw.matches(".*[A-Z].*");
    	boolean pwLowerCase = pw.matches(".*[a-z].*");
    	boolean pwSymbol = pw.matches(".*[^\\w].*");
    	boolean pwNoComma = !pw.matches(".*[,].*");
    	boolean pw2Correct = pw.equals(pw2);
    	
    	if (!validSid(sid)) {
        	return "Invalid sid";
        }
    	else if(sidExist) {
        	return "This SID was registered";
    	}
        else if(name.length()>15) {
        	return "Username too long";
        }
        else if (!emailValid) {
        	return "Invalid email";
        }
        else if (!pwLongEnough) {
        	return "Password must be at least 8 characters";
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
        Account user = new Account(sid, name, email, pw);
    	accounts.put(sid, user);
    	return "Register successfully";
	}
	
	public String login(String sid, String pw) {		
    	boolean sidExist = accounts.containsKey(sid);
    	
        if (!validSid(sid)) {
        	return "Invalid SID";
        }
        else if (!sidExist) {
        	return "Wrong SID or password";
        }
        else {
            Account account = accounts.get(sid);
            
            if (!pw.equals(account.getPw())) {
            	return "Wrong SID or password";
            }
            else {
        		return "Login Successfully!";
            }
        }
	}
	
	public String checkForget(String sid, String email) {    	
    	boolean sidExist = accounts.containsKey(sid);
    	
        if (!validSid(sid)) {
        	return "Invalid sid";
        }
        else if (!sidExist) {
        	return "Wrong SID or email";
        }
    	Account account = accounts.get(sid);
    	
        if (!email.equals(account.getEmail())) {
        	return "Wrong SID or email";
        }
    	RandomPw randomPw = RandomPw.getInstance();
    	String pw = randomPw.randomPw();

		account.editPw(sid, account.getPw(), pw, pw);
    	
    	accounts.put(sid, account);
    	
    	SendEmail send = SendEmail.getInstance();
    	send.sendNewPw(account.getEmail(), pw);
    	return "A temporary password has been sent to your email\nPlease login again";
	}
    
    public void put(String sid, Account account) {
    	accounts.put(sid, account);
    }
    
    public void remove(String sid) {
    	accounts.remove(sid);
    }
    
    public Account getAccount(String sid) {
		return accounts.get(sid);
	}

	public boolean containsKey(String sid) {
		return accounts.containsKey(sid);
	}
}
