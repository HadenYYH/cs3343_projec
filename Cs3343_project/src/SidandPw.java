import java.util.HashMap;

public class SidandPw {
	private static HashMap<String,String> loginInfo = new HashMap<String,String>();
	private static SidandPw instance = null;
	
    private SidandPw(){
    	loginInfo.put("56512971", "123456");
    	loginInfo.put("12345678", "12345678");
    }
    
    public static SidandPw getInstance(){
    	if (instance == null) {
            instance = new SidandPw();
    	}
    	return instance;
    }
    
    public void put(String sid, String pw) {
    	loginInfo.put(sid, pw);       
    }
    
    public boolean containsKey(String sid) {
    	return loginInfo.containsKey(sid);
    }
    
    public String get(String sid) {
    	return loginInfo.get(sid);       
    }
}
