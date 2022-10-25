import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

import java.io.*;
import java.util.*;

public class Services {
    
	public StringBuilder getHashPw(String sid, String pw) throws NoSuchAlgorithmException{
		String hash_pw = "";
		String sid_and_pw = sid+pw;
		StringBuilder sb = new StringBuilder();
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(sid_and_pw.getBytes(StandardCharsets.UTF_8));

		hash_pw = hash.toString();
		for (byte b : hash) {
		    sb.append(String.format("%02X", b));
		}
		return sb;
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
	
	public void writeUserData(String sid, String name, String email, StringBuilder hashed_pw){
		String user_data = sid+","+name+","+email+","+hashed_pw;
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
	
	public ArrayList<String> getALLTextFileInDirectory() {
		String dirPath = "./src/user/";
	    File dir = new File(dirPath);
	    ArrayList<String> file_array = new ArrayList<String>();
	    if(dir.listFiles()!=null) {
		    for (File f : dir.listFiles()) {
		        if (f.isFile() && f.getName().endsWith(".txt")) {
		        	file_array.add(f.getName());
		        }
		    }
	    }
	    return file_array;
	}
	
	public boolean checkEmail(String email,ArrayList<String> file_list) {
		String user_data = "";
		String file_name = "./src/user/";
		for(int i=0; i<file_list.size();i++) {
			String user_data_array [];
		    File target_file = new File("./src/user/" + file_list.get(i));
		    Scanner myReader;
			try {
				myReader = new Scanner(target_file);
			    user_data = myReader.nextLine();
		        myReader.close();
		        user_data_array = user_data.split(",");
		        if(email.equals(user_data_array[2])) {
		    		return true;
		        }
			} catch (FileNotFoundException e) {
				continue;
			}
		}
		return false;
	}
}
