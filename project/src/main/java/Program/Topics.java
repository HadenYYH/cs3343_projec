package Program;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Topics  {  

	private static Map<String, Topic> topics = new HashMap<String, Topic>();
	private static Topics instance = null;
	
    private Topics(){    	
    	String id = "00000000";
    	Account creator = Accounts.getInstance().getAccount("12345678");
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
    
    public String createTopic(Account creator, String name, String description) {
    	if(name.equals("")){
    		return "Please input topic name";
    	}
    	if(description.equals("")){
    		return "Please input topic description";
    	}
    	String id = String.format("%08d", topics.size());
    	topics.put(id, new Topic(id, creator, name, description));
    	return "Topic created\n id: " + id;
    }
    
    public Vector<Topic> getVector(Account user){
    	Vector<Topic> items = new Vector<Topic>();
    	
    	for (Topic topic : topics.values()) {
			if(topic.checkCreator(user)) {
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
	
	public void put(String id, Topic topic) {
    	topics.put(id, topic);
    }

	public void remove(Topic topic) {
    	topics.remove(topic.getId());
	}
}