import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Topic {
	private String id;
    private String name;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private Account creator;
    
    public void resetDate() {
		start = LocalDate.now();
		end = start.plusDays(10);
    }
    
    public Topic(Account creator, String name, String description) {
		this.id = String.format("%08d", Topics.getInstance().getSize());
		this.creator = creator;
		this.name = name;
		this.description = description;
		resetDate();
		Topics.getInstance().putTopic(id, this);
		creator.putTopic(this);
		JOptionPane.showMessageDialog(null, "Topic created\n id: " + id);
	}
    
    public Topic(String id, Account creator, String name, String description) {
		this.id = id;
		this.creator = creator;
		this.name = name;
		this.description = description;
		resetDate();
		creator.putTopic(this);
	}
    
	public String getName() {
		return name;
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
	
	@Override
	public String toString() {
		return name;
	}
}
