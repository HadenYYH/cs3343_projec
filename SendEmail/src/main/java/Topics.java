import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;

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
    
    public boolean createTopic(Account creator, String name, String description) {
    	if(name.equals("")){
    		JOptionPane.showMessageDialog(null, "Please input topic name");
    		return false;
    	}
    	if(description.equals("")){
    		JOptionPane.showMessageDialog(null, "Please input topic description");
    		return false;
    	}
    	String id = String.format("%08d", topics.size());
    	topics.put(id, new Topic(id, creator, name, description));
		JOptionPane.showMessageDialog(null, "Topic created\n id: " + id);
    	return true;
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

	public boolean remove(Topic topic) {
    	String message = "Are you sure you want to delete this topic?\n This cannot be undone.";
		int reply = JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.YES_NO_OPTION);
		if(reply == JOptionPane.YES_OPTION) {
			topics.remove(topic.getId());
			return true;
		}
		return false;
	}
}