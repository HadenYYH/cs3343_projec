import javax.swing.JOptionPane;

public class Account {
	private String sid;
	private String name;
	private String email;
	private String pw;
	private boolean loggedIn;;
	
	public Account() {
		loggedIn = false;
		sid = "not logged in";
		name = "not logged in";
		email = "not logged in";
		pw = "not logged in";
	}
	
	public Account(String sid, String name, String email, String pw) {
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.pw = pw;
		loggedIn = true;
	}
	
	private boolean validSid(String sid) {
		if((sid.length() == 8) & sid.matches("[0-9]+")) {
			return true;
		}
		return false;
	}
	
	public void register(String sid, String name, String email, String pw, String pw2) {
    	boolean emailValid = email.endsWith("@my.cityu.edu.hk");
    	boolean sidExist = SidandData.getInstance().containsKey(sid);
		boolean pwLongEnough = (pw.length() >= 8);
    	boolean pwUpperCase = pw.matches(".*[A-Z].*");
    	boolean pwLowerCase = pw.matches(".*[a-z].*");
    	boolean pwSymbol = pw.matches(".*[^\\w].*");
    	boolean pwNoComma = !pw.matches(".*[,].*");
    	boolean pw2Correct = pw.equals(pw2);
    	
    	if (!validSid(sid)) {
        	JOptionPane.showMessageDialog(null, "Invalid sid");
        }
    	else if(sidExist) {
        	JOptionPane.showMessageDialog(null, "This SID was registered");
    	}
        else if(name.length()>15) {
        	JOptionPane.showMessageDialog(null, "Username too long");
        }
        else if (!emailValid) {
        	JOptionPane.showMessageDialog(null, "Invalid email");
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
    		this.email = email;
    		this.name = name;
    		this.pw = pw;
    		loggedIn = true;
    		SidandData.getInstance().put(sid, this);
    		JOptionPane.showMessageDialog(null, "Register sucessfully");
        }
	}
	
	public void login(String sid, String pw) {		
    	boolean sidExist = SidandData.getInstance().containsKey(sid);
    	
        if (!validSid(sid)) {
        	JOptionPane.showMessageDialog(null, "Invalid sid");
        }
        else if (!sidExist) {
        	JOptionPane.showMessageDialog(null, "Wrong SID or password");
        }
        
        Account account = SidandData.getInstance().getAccount(sid);
        
        if (!pw.equals(account.getPw())) {
        	JOptionPane.showMessageDialog(null, "Wrong SID or password"+account.getPw());
        }
        else {
        	this.sid = sid;
    		this.email = account.getEmail();
    		this.name = account.getName();
    		this.pw = account.getPw();
    		loggedIn = true;
    		SidandData.getInstance().put(sid, this);
    		JOptionPane.showMessageDialog(null, "Login Sucessfully!");
        }
	}
	
	public boolean edit(String sid, String name, String email, String pw) {
    	boolean emailValid = email.endsWith("@my.cityu.edu.hk");
    	boolean sidChanged = !sid.equals(this.sid);
    	boolean sidExist = SidandData.getInstance().containsKey(sid);
    	
    	if (!validSid(sid)) {
        	JOptionPane.showMessageDialog(null, "Invalid sid");
        }
    	else if(sidChanged & sidExist) {
        	JOptionPane.showMessageDialog(null, "This SID was registered");
    	}
        else if (!emailValid) {
        	JOptionPane.showMessageDialog(null, "Invalid email");
        }
        else if(name.length()>15) {
        	JOptionPane.showMessageDialog(null, "Username too long");
        }
    	
        Account account = SidandData.getInstance().getAccount(sid);
        
    	if (!pw.equals(account.getPw())) {
        	JOptionPane.showMessageDialog(null, "Wrong SID or password");
        }
        else {
    		this.sid = sid;
    		this.email = email;
    		this.name = name;
    		SidandData.getInstance().put(sid, this);
    		JOptionPane.showMessageDialog(null, "Edit sucessfully");
    		return true;
        }
    	return false;
	}
	
	public boolean editPw(String sid, String oldPw, String pw, String pw2) {		
		boolean pwLongEnough = (pw.length() >= 8);
    	boolean pwUpperCase = pw.matches(".*[A-Z].*");
    	boolean pwLowerCase = pw.matches(".*[a-z].*");
    	boolean pwSymbol = pw.matches(".*[^\\w].*");
    	boolean pwNoComma = !pw.matches(".*[,].*");
    	boolean pw2Correct = pw.equals(pw2);

        Account account = SidandData.getInstance().getAccount(sid);
    	
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
    		SidandData.getInstance().put(sid, this);
    		JOptionPane.showMessageDialog(null, "Password Changed");
    		return true;
        }
    	return false;
	}
	
	public boolean checkForget(String sid) {    	
    	boolean sidExist = SidandData.getInstance().containsKey(sid);
    	
        if (!validSid(sid)) {
        	JOptionPane.showMessageDialog(null, "Invalid sid");
        	return false;
        }
        else if (!sidExist) {
        	JOptionPane.showMessageDialog(null, "Wrong SID");
        	return false;
        }
        else {
        	RandomPw randomPw = RandomPw.getInstance();
        	String pw = randomPw.randomPw();

            Account account = SidandData.getInstance().getAccount(sid);
    		this.sid = sid;
    		this.email = account.getEmail();
    		this.name = account.getName();
        	this.pw = pw;
        	
        	SidandData.getInstance().put(sid, this);
        	
        	SendEmail send = SendEmail.getInstance();
        	send.sendNewPw(email, pw);
        	JOptionPane.showMessageDialog(null, "A temporary password has been sent to your email\nPlease login again");
        	return true;
        }
	}
	
	public void logout() {
		loggedIn = false;
		SidandData.getInstance().put(sid, this);
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
	
	public boolean loggedIn() {
		return loggedIn;
	}

	public boolean checkSid(String sid) {
		if(sid.equals("all") | sid.equals(this.sid)) {
			return true;
		}
		else {
			return false;
		}
	}
}