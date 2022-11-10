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

	private void message(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
    
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

	public boolean edit(String name, String description) {
		this.name = name;
		this.description = description;
		Topics.getInstance().put(id, this);
		message("Edit successfully");
		return true;
	}
	
	public boolean vote(Account user) {
    	String message = "Do you agree on this topic?";
		int reply = JOptionPane.showConfirmDialog(null, message, "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(votes.containsKey(user)){
			if(votes.get(user)) {
				if(reply == JOptionPane.YES_OPTION) {
					message("You have already agreed on this topic");
					return false;
				}
				else if(reply == JOptionPane.NO_OPTION) {
					votes.put(user, false);
					message("Disagree successfully");
					agrees--;
					disagrees++;
				}
			}
			else {
				if(reply == JOptionPane.YES_OPTION) {
					votes.put(user, true);
					message("Agree successfully");
					agrees++;
					disagrees--;
				}
				else if(reply == JOptionPane.NO_OPTION) {
					message("You have already disagreed on this topic");
					return false;
				}
			}
		}
		else {
			if(reply == JOptionPane.YES_OPTION) {
				votes.put(user, true);
				message("Agree successfully");
				agrees++;
			}
			else if(reply == JOptionPane.NO_OPTION) {
				votes.put(user, false);
				message("Disagree successfully");
				disagrees++;
			}
		}
		return true;
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
		return user.checkCreator(creator);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
