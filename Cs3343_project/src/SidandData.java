import java.util.HashMap;

public class SidandData {
	private static HashMap<String, String[]> loginInfo = new HashMap<String,String[]>();
	private static SidandData instance = null;
	
    private SidandData(){
    	String name = "cs3343";
    	String email = "cd3343@my.cityu.edu.hk";
    	String pw = "aA123456!";
    	String[] data = {name, email, pw};
    	loginInfo.put("12345678", data);
    }
    
    public static SidandData getInstance(){
    	if (instance == null) {
            instance = new SidandData();
    	}
    	return instance;
    }
    
    public void put(String sid, String name, String email, String pw) {
    	String[] data = {name, email, pw};
    	loginInfo.put(sid, data);       
    }
    
    public boolean containsKey(String sid) {
    	return loginInfo.containsKey(sid);
    }
    public String getName(String sid) {
    	return loginInfo.get(sid)[0];       
    }
    public String getEmail(String sid) {
    	return loginInfo.get(sid)[1];       
    }
    
    public String getPw(String sid) {
    	return loginInfo.get(sid)[2];       
    }
}