package Program;
import javax.swing.JOptionPane;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Account {
	private String name;
	private boolean loggedIn;
	
	public Account() {
		name = "Please login";
		loggedIn = false;
	}
	
	public Account(String sid) {
		SidandData sidandPw = SidandData.getInstance();
		name = sidandPw.getName(sid);
		loggedIn = true;
	}
	
	private boolean validSid(String sid) {
		if((sid.length() == 8) & sid.matches("[0-9]+")) {
			return true;
		}
		return false;
	}
	
	public void register(String sid, String name, String email, String pw, String pw2) {
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
        	JOptionPane.showMessageDialog(null, "Invalid sid");
        }
    	else if(sidExist) {
        	JOptionPane.showMessageDialog(null, "This SID was registered");
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
        else if(name.length()>15) {
        	JOptionPane.showMessageDialog(null, "Username too long");
        }
        else if(services.checkEmail(email, file_list)){
        	JOptionPane.showMessageDialog(null,"Email already used");
        }
        else if(fileExist!=null){
        	JOptionPane.showMessageDialog(null,"SID already used");
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
    		JOptionPane.showMessageDialog(null, "Register sucessfully");
        }
	}
	
	public void login(String sid, String pw) throws NoSuchAlgorithmException {
		SidandData sidandPw = SidandData.getInstance();
    	Services services = new Services();
    	
        if (!validSid(sid)) {
        	JOptionPane.showMessageDialog(null, "Invalid sid");
        }
        else {
        	String user_data = services.getUserDataBySid(sid);
	        if(user_data!=null) {
	        	String user_data_array [];
		        user_data_array = user_data.split(",");
		        StringBuilder encrypted_pw = services.getHashPw(sid, pw);
	        	if (encrypted_pw.toString().equals(user_data_array[3])) {
	        		loggedIn = true;
	        		JOptionPane.showMessageDialog(null, "Login Sucessfully!");
		        }else {
		        	JOptionPane.showMessageDialog(null, "Wrong SID or password");
	        	}
	        }else {
	        	JOptionPane.showMessageDialog(null, "Wrong SID or password");
	        }
        }
        
	}
	
	public boolean checkForget(String sid) {
    	Services services = new Services();
    	
    	if (!validSid(sid)) {
        	JOptionPane.showMessageDialog(null, "Invalid sid");
        	return false;
        }
        else {
        	String user_data = services.getUserDataBySid(sid);
	        if(user_data!=null) {
	        	//Send email
				String user_data_array [];
		        user_data_array = user_data.split(",");
		        String email = user_data_array[2];

	        	JOptionPane.showMessageDialog(null, "A temporary password has been sent to your email\nPlease login again");
	        	return true;
	        	
	        }else {
	        	JOptionPane.showMessageDialog(null, "Wrong SID or password");
	        	return false;
	        }
        }
	}
	
	public String getName() {
		return name;
	}
	
	public boolean loggedIn() {
		return loggedIn;
	}
}