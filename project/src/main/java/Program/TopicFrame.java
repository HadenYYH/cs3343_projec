package Program;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;


@SuppressWarnings("serial")
public class TopicFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel id;
    private JLabel tid;
    private JLabel creator;
    private JLabel tcreator;
    private JLabel description;
    private JLabel tdescription;
    private JLabel dates;
    private JLabel tdates;
    private JLabel votes;
    private float agrees;
    private float disagrees;
    private JLabel tvotes;
    private JLabel nvotes;
	private JButton vote;
	private JButton edit;
	private JButton back;
    private Account user;
    private Topic topic;

	private String message(String message) {
		JOptionPane.showMessageDialog(null, message);
		return message;
	}
        
    public TopicFrame(Account user, Topic topic) {
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
 
        id = new JLabel("Topic ID");
        id.setFont(new Font("Arial", Font.PLAIN, 20));
        id.setSize(100, 20);
        id.setLocation(250, 100);
        container.add(id);
 
        tid = new JLabel(topic.getId());
        tid.setFont(new Font("Arial", Font.PLAIN, 20));
        tid.setSize(100, 20);
        tid.setLocation(250, 125);
        container.add(tid);
 
        creator = new JLabel("Creator");
        creator.setFont(new Font("Arial", Font.PLAIN, 20));
        creator.setSize(100, 20);
        creator.setLocation(400, 100);
        container.add(creator);
 
        tcreator = new JLabel(topic.getCreator().getName());
        tcreator.setFont(new Font("Arial", Font.PLAIN, 20));
        tcreator.setSize(300, 20);
        tcreator.setLocation(400, 125);
        container.add(tcreator);
 
        dates = new JLabel("Voting period");
        dates.setFont(new Font("Arial", Font.PLAIN, 20));
        dates.setSize(500, 20);
        dates.setLocation(250, 175);
        container.add(dates);
 
        tdates = new JLabel(topic.getStart().toString() + '~' + topic.getEnd().toString());
        tdates.setFont(new Font("Arial", Font.PLAIN, 20));
        tdates.setSize(300, 20);
        tdates.setLocation(250, 200);
        container.add(tdates);

        agrees = topic.getAgrees();
        disagrees = topic.getDisagrees();
        votes = new JLabel("Agree                                  Disagree");
        votes.setFont(new Font("Arial", Font.PLAIN, 20));
        votes.setSize(500, 20);
        votes.setLocation(250, 250);
        container.add(votes);

        tvotes = new JLabel(String.format("%.0f", agrees) + "                                         " + String.format("%.0f", disagrees));
        tvotes.setFont(new Font("Arial", Font.PLAIN, 20));
        tvotes.setSize(500, 20);
        tvotes.setLocation(250, 275);
        container.add(tvotes);

        int blocks = 0;
        if((agrees + disagrees) > 0) {
        	blocks = Math.round(agrees / (agrees + disagrees) * 30);
        }
        
        String black = new String(new char[blocks]).replace("\0", "\u2B1B");
        String white = new String(new char[30-blocks]).replace("\0", "\u2B1C");
        	
        nvotes = new JLabel(black + white);
        nvotes.setSize(500, 20);
        nvotes.setLocation(250, 300);
        container.add(nvotes);
 
        description = new JLabel("Description");
        description.setFont(new Font("Arial", Font.PLAIN, 20));
        description.setSize(300, 20);
        description.setLocation(250, 325);
        container.add(description);
        
        tdescription = new JLabel("<html><body style='width: 300px'>" + topic.getDescription());
        tdescription.setFont(new Font("Arial", Font.PLAIN, 15));
        tdescription.setSize(400, 100);
        tdescription.setLocation(250, 350);
        container.add(tdescription);
        
        vote = new JButton("vote");
        vote.setFont(new Font("Arial", Font.PLAIN, 15));
        vote.setSize(100, 20);
        vote.setLocation(250, 475);
        vote.addActionListener(this);
        container.add(vote);
        
        edit = new JButton("edit");
        edit.setFont(new Font("Arial", Font.PLAIN, 15));
        edit.setSize(100, 20);
        edit.setLocation(400, 475);
        edit.addActionListener(this);
        container.add(edit);
 
        back = new JButton("back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(100, 20);
        back.setLocation(550, 475);
        back.addActionListener(this);
        container.add(back);
 
        setVisible(true);
        if(user.checkUser(NullAccount.getInstance())) {
        	edit.setVisible(false);
        	vote.setVisible(false);
        }
        else if(!topic.checkCreator(user)) {
        	edit.setVisible(false);
        }
        if(LocalDate.now().isAfter(topic.getEnd())) {
        	vote.setVisible(false);
        }
	}

	// method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == vote) {
        	if(message(user.vote(topic)).contains("successfully")) {
            	new TopicFrame(user, topic);
            	this.dispose();
        	}
        }
        else if (e.getSource() == edit) {
        	new EditTopicFrame(user, topic);
        	this.dispose();
        }
        else if (e.getSource() == back) {
        	new MenuFrame(user);
        	this.dispose();
        }
    }
}
