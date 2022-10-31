import java.util.HashMap;
import java.util.Map;

public class SidandData {
	private static Map<String, Account> loginInfo = new HashMap<String, Account>();
	private static SidandData instance = null;
	
    private SidandData(){
    	String sid = "12345678";
    	String name = "cs3343";
    	String email = "choulwu2-c@my.cityu.edu.hk";
    	String pw = "aA123456!";
    	loginInfo.put(sid, new Account(sid, name, email, pw));
    }
    
    public static SidandData getInstance(){
    	if (instance == null) {
            instance = new SidandData();
    	}
    	return instance;
    }
    
    public void put(String sid, Account account) {
    	loginInfo.put(sid, account);
    }
    
    public Account getAccount(String sid) {
		return loginInfo.get(sid);
	}

	public boolean containsKey(String sid) {
    	return loginInfo.containsKey(sid);
    }
}
