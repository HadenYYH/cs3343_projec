import javax.swing.JOptionPane;

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
	
	public boolean edit(String sid, String name, String email, String pw) {
    	boolean emailValid = email.endsWith("@my.cityu.edu.hk");
    	boolean sidChanged = !sid.equals(this.sid);
    	boolean sidExist = Accounts.getInstance().containsKey(sid);
    	
    	if (!validSid(sid)) {
        	JOptionPane.showMessageDialog(null, "Invalid sid");
        	return false;
        }
    	else if(sidChanged & sidExist) {
        	JOptionPane.showMessageDialog(null, "This SID was registered");
        	return false;
    	}
        else if (!emailValid) {
        	JOptionPane.showMessageDialog(null, "Invalid email");
        	return false;
        }
        else if(name.length()>15) {
        	JOptionPane.showMessageDialog(null, "Username too long");
        	return false;
        }
    	
        Account account = Accounts.getInstance().getAccount(sid);
        
    	if (!pw.equals(account.getPw())) {
        	JOptionPane.showMessageDialog(null, "Wrong SID or password");
        	return false;
        }
        else {
    		this.sid = sid;
    		this.email = email;
    		this.name = name;
    		Accounts.getInstance().put(sid, this);
    		JOptionPane.showMessageDialog(null, "Edit sucessfully");
    		return true;
        }
	}
	
	public boolean editPw(String sid, String oldPw, String pw, String pw2) {		
		boolean pwLongEnough = (pw.length() >= 8);
    	boolean pwUpperCase = pw.matches(".*[A-Z].*");
    	boolean pwLowerCase = pw.matches(".*[a-z].*");
    	boolean pwSymbol = pw.matches(".*[^\\w].*");
    	boolean pwNoComma = !pw.matches(".*[,].*");
    	boolean pw2Correct = pw.equals(pw2);

        Account account = Accounts.getInstance().getAccount(sid);
    	
    	if (!oldPw.equals(account.getPw())) {
        	JOptionPane.showMessageDialog(null, "Wrong password");
        }
        else if (!pwLongEnough) {
        	JOptionPane.showMessageDialog(null, "Password must be longer than 8 chracters");
        }
        else if (!pwUpperCase) {
        	JOptionPane.showMessageDialog(null, "Password must contain an upper case letter");
        }
        else if (!pwLowerCase) {
        	JOptionPane.showMessageDialog(null, "Password must contain an lower case letter");
        }
        else if (!pwSymbol) {
        	JOptionPane.showMessageDialog(null, "Password must contain a non-letter symbol");
        }
        else if (!pwNoComma) {
        	JOptionPane.showMessageDialog(null, "Password must not contain a comma");
        }
        else if (!pw2Correct) {
        	JOptionPane.showMessageDialog(null, "Two passwords are different");
        }
        else {
    		this.sid = sid;
    		this.pw = pw;
    		Accounts.getInstance().put(sid, this);
    		JOptionPane.showMessageDialog(null, "Password Changed");
    		return true;
        }
    	return false;
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

	public boolean checkCreator(Account user) {
		if(user == null) {
			return true;
		}
		else if(user.equals(this)) {
			return true;
		}
		else {
			return false;
		}
	}
}