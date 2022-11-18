package Program;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class EditTopicFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel id;
    private JLabel tid;
    private JLabel creator;
    private JLabel tcreator;
    private JLabel description;
    private JTextArea tdescription;
    private JLabel dates;
    private JLabel tdates;
	private JButton sub;
    private JButton reset;
	private JButton delete;
	private JButton back;
    private Account user;
    private Topic topic;

	private String message(String message) {
		JOptionPane.showMessageDialog(null, message);
		return message;
	}
        
    public EditTopicFrame(Account user, Topic topic) {
    	this.user = user;
    	this.topic = topic;
    	
        setTitle(topic.toString());
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        title = new JLabel(topic.toString());
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 50);
        title.setLocation(250, 25);
        container.add(title);
 
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(250, 100);
        container.add(name);
 
        tname = new JTextField(topic.toString());
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(150, 20);
        tname.setLocation(250, 125);
        container.add(tname);
 
        id = new JLabel("Topic ID");
        id.setFont(new Font("Arial", Font.PLAIN, 20));
        id.setSize(100, 20);
        id.setLocation(500, 100);
        container.add(id);
 
        tid = new JLabel(topic.getId());
        tid.setFont(new Font("Arial", Font.PLAIN, 20));
        tid.setSize(100, 20);
        tid.setLocation(500, 125);
        container.add(tid);
 
        creator = new JLabel("Creator");
        creator.setFont(new Font("Arial", Font.PLAIN, 20));
        creator.setSize(500, 20);
        creator.setLocation(250, 175);
        container.add(creator);
 
        tcreator = new JLabel(topic.getCreator().getName());
        tcreator.setFont(new Font("Arial", Font.PLAIN, 20));
        tcreator.setSize(300, 20);
        tcreator.setLocation(250, 200);
        container.add(tcreator);
 
        dates = new JLabel("Voting period");
        dates.setFont(new Font("Arial", Font.PLAIN, 20));
        dates.setSize(500, 20);
        dates.setLocation(250, 250);
        container.add(dates);
 
        tdates = new JLabel(topic.getStart().toString() + '~' + topic.getEnd().toString());
        tdates.setFont(new Font("Arial", Font.PLAIN, 20));
        tdates.setSize(300, 20);
        tdates.setLocation(250, 275);
        container.add(tdates);
 
        description = new JLabel("Description");
        description.setFont(new Font("Arial", Font.PLAIN, 20));
        
        description.setSize(300, 20);
        description.setLocation(250, 325);
        container.add(description);
        
        tdescription = new JTextArea(topic.getDescription());
        tdescription.setFont(new Font("Arial", Font.PLAIN, 15));
        tdescription.setSize(400, 60);
        tdescription.setLocation(250, 350);
        tdescription.setLineWrap(true);
        tdescription.setWrapStyleWord(true);
        container.add(tdescription);
        
        sub = new JButton("submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(150, 20);
        sub.setLocation(250, 450);
        sub.addActionListener(this);
        container.add(sub);
 
        reset = new JButton("reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(150, 20);
        reset.setLocation(550, 450);
        reset.addActionListener(this);
        container.add(reset);
 
        delete = new JButton("delete");
        delete.setFont(new Font("Arial", Font.PLAIN, 15));
        delete.setSize(150, 20);
        delete.setLocation(250, 475);
        delete.addActionListener(this);
        container.add(delete);
 
        back = new JButton("back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(150, 20);
        back.setLocation(550, 475);
        back.addActionListener(this);
        container.add(back);
 
        setVisible(true);
	}

	// method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
        	String nameText = tname.getText();
        	String descriptionText = tdescription.getText();
        	
        	if(message(topic.edit(nameText, descriptionText)).equals("Edit successfully")) {
            	new MenuFrame(user);
            	this.dispose();
        	}
        }
        else if (e.getSource() == reset) {
            tname.setText(topic.toString());
            tdescription.setText(topic.getDescription());
        }
        else if (e.getSource() == delete) {
    		if(Topics.getInstance().remove(topic)) {
    			new ViewFrame(user);
            	this.dispose();
    		}
        }
        else if (e.getSource() == back) {
        	new ViewFrame(user);
        	this.dispose();
        }
    }
}
