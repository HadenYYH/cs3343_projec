package Program;

public class Account {
	private String sid;
	private String name;
	private String email;
	private String pw;
	
	public Account(String sid, String name, String email, String pw) {
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.pw = pw;
	}
	
	private boolean validSid(String sid) {
		if((sid.length() == 8) & sid.matches("[0-9]+")) {
			return true;
		}
		return false;
	}
	
	public String edit(String sid, String name, String email, String pw) {
    	boolean emailValid = email.endsWith("@my.cityu.edu.hk");
    	boolean sidChanged = !sid.equals(this.sid);
    	boolean sidExist = Accounts.getInstance().containsKey(sid);
    	
    	if (!validSid(sid)) {
        	return "Invalid sid";
        }
    	else if(sidChanged & sidExist) {
        	return "This SID was registered";
    	}
        else if (!emailValid) {
        	return "Invalid email";
        }
        else if(name.length()>15) {
        	return "Username too long";
        }
    	
        Account account = Accounts.getInstance().getAccount(sid);
        
    	if (!pw.equals(account.getPw())) {
        	return "Wrong password";
        }
		this.sid = sid;
		this.email = email;
		this.name = name;
		Accounts.getInstance().put(sid, this);
		return "Edit successfully";
	}
	
	public String editPw(String sid, String oldPw, String pw, String pw2) {		
		boolean pwLongEnough = (pw.length() >= 8);
    	boolean pwUpperCase = pw.matches(".*[A-Z].*");
    	boolean pwLowerCase = pw.matches(".*[a-z].*");
    	boolean pwSymbol = pw.matches(".*[^\\w].*");
    	boolean pwNoComma = !pw.matches(".*[,].*");
    	boolean pw2Correct = pw.equals(pw2);

        Account account = Accounts.getInstance().getAccount(sid);
    	
    	if (!oldPw.equals(account.getPw())) {
    		return "Wrong password";
        }
        else if (!pwLongEnough) {
        	return "Password must contain at least 8 characters";
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
		this.sid = sid;
		this.pw = pw;
		Accounts.getInstance().put(sid, this);
		return "Password Changed";
	}
	
	public String getSid() {
		return sid;
	}
	
	public String getName() {
    	return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPw() {
		return pw;
	}

	public boolean checkUser(Account user) {
		return user.equals(this);
	}
}