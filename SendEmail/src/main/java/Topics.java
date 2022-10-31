import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JLabel;

public class Topics  {  

	private static Map<String, Topic> topics = new HashMap<String, Topic>();
	private static Topics instance = null;
	
    private Topics(){
    	String sid = "12345678";
    	String sname = "cs3343";
    	String email = "choulwu2-c@my.cityu.edu.hk";
    	String pw = "aA123456!";
    	
    	String id = "00000000";
    	Account creator = new Account(sid, sname, email, pw);
    	String name = "Test";
    	String description = "This is a test topic.";
		topics.put(id, new Topic(id, creator, name, description));
    }
    
    public static Topics getInstance(){
    	if (instance == null) {
            instance = new Topics();
    	}
    	return instance;
    }
    
    public Vector<Topic> getVector(String sid){
    	Vector<Topic> items = new Vector<Topic>();
    	
    	for (Topic topic : topics.values()) {
			if(topic.checkCreator(sid)) {
            	items.add(topic);
			}
        }
        
    	return items;
    }
    
    public boolean containsKey(String id) {
    	return topics.containsKey(id);
    }
    
    public Topic getTopic(String id) {
    	return topics.get(id);
    }

	public int getSize() {
		return topics.size();
	}
	
	public void put(String id, Topic topic) {
    	topics.put(id, topic);
    }

	public void remove(String id) {
		topics.remove(id);
		
	}
}