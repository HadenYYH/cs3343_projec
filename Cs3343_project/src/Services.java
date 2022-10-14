import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Services {
    
	public String getHashPw(String sid, String pw) throws NoSuchAlgorithmException{
		String hash_pw = "";
		String sid_and_pw = sid+pw;
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(sid_and_pw.getBytes(StandardCharsets.UTF_8));

		hash_pw = hash.toString();
        System.out.println(hash_pw);
		
		return hash_pw;
	}
	
	public String getUserDataBySid(String sid){
		String user_data = "";
		String file_name = sid + ".txt";
		try {
		    File target_file = new File("./src/user/" +file_name);
		    Scanner myReader = new Scanner(target_file);
		    user_data = myReader.nextLine();
	        myReader.close();
	      } catch (FileNotFoundException e) {
	    	user_data = null;
	      }
	    
		return user_data;
	}
	
	public void writeUserData(String sid, String name, String email, String hased_pw){
		String user_data = sid+","+name+","+email+","+hased_pw;
		String file_name = "./src/user/" + sid + ".txt";
		
		try {
		    File target_file = new File(file_name);
		    if (target_file.createNewFile()) {
		    	FileWriter myWriter = new FileWriter(file_name);
		        myWriter.write(user_data);
		        myWriter.close();
		    } else {
		        System.out.println("File already exists.");
		      }
		} catch (IOException e) {
		      System.out.println(e);
		      e.printStackTrace();
		}
	    
	}
}
