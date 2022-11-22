package Program;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Topic {
	private String id;
    private String name;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private Map<Account, Boolean> votes;
    private int agrees;
    private int disagrees;
    private Account creator;
    
    public void resetDate() {
		start = LocalDate.now();
		end = start.plusDays(10);
    }
    
    public void resetVote() {
    	votes = new HashMap<Account, Boolean>();
    	agrees = 0;
    	disagrees = 0;
    }
    
    public Topic(String id, Account creator, String name, String description) {
		this.id = id;
		this.creator = creator;
		this.name = name;
		this.description = description;
		resetDate();
		resetVote();
	}

	public String edit(String name, String description) {
		if(name.equals("")){
    		return "Please input topic name";
    	}
    	if(description.equals("")){
    		return "Please input topic description";
    	}
    	if(this.name.equals(name) & this.description.equals(description)){
    		return "No changes found";
    	}
		this.name = name;
		this.description = description;
		Topics.getInstance().put(id, this);
		return "Edit successfully";
	}
	
	public String voted(Account user, int reply) {
		if(votes.containsKey(user)){
			if(votes.get(user)) {
				if(reply == JOptionPane.YES_OPTION) {
					return "You have already agreed on this topic";
				}
				else if(reply == JOptionPane.NO_OPTION) {
					votes.put(user, false);
					agrees--;
					disagrees++;
					return "Disagree successfully";
				}
			}
			else {
				if(reply == JOptionPane.YES_OPTION) {
					votes.put(user, true);
					agrees++;
					disagrees--;
					return "Agree successfully";
				}
				else if(reply == JOptionPane.NO_OPTION) {
					return "You have already disagreed on this topic";
				}
			}
		}
		else {
			if(reply == JOptionPane.YES_OPTION) {
				votes.put(user, true);
				agrees++;
				return "Agree successfully";
			}
			else if(reply == JOptionPane.NO_OPTION) {
				votes.put(user, false);
				disagrees++;
				return "Disagree successfully";
			}
		}
		return "Vote cancelled";
	}
	
	public boolean remove() {
		String message = "Are you sure you want to delete this topic?\n This cannot be undone.";
		int reply = JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.YES_NO_OPTION);
		if(reply == JOptionPane.YES_OPTION) {
			Topics.getInstance().remove(this);
			return true;
		}
		return false;
	}

	public String getId() {
		return id;
	}
	
	public LocalDate getStart(){
		return start;
	}
	
	public LocalDate getEnd(){
		return end;
	}
	
	public Account getCreator() {
		return creator;
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getAgrees() {
		return agrees;
	}
	
	public int getDisagrees() {
		return disagrees;
	}
	
	public boolean checkCreator(Account user) {
		return user.checkUser(creator);
	}
	
	@Override
	public String toString() {
		return name;
	}
}