package Program;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

@SuppressWarnings("serial")
public class ViewFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel lsearch;
    private JTextField tsearch;
	private JButton search;
    private String searchTip = "Topic ID is consist of 8 digits";
    
    private JList<Topic> list;

	private JButton select;
	private JButton back;
	private Account user;

	public String message(String message) {
		JOptionPane.showMessageDialog(null, message);
		return message;
	}
	
	FocusListener textFocusListener = new FocusListener() {
        public void focusGained(FocusEvent focusEvent) {
        	JTextField src = (JTextField)focusEvent.getSource();
        	if((src == tsearch) & (src.getText().equals(searchTip))) {
                src.setText("");
        	}
        }

        public void focusLost(java.awt.event.FocusEvent focusEvent) {
        	JTextField src = (JTextField)focusEvent.getSource();
        	if((src == tsearch) & (src.getText().isEmpty())) {
        		src.setText(searchTip);
        	}
        }
    };
	
	
    // constructor, to initialize the components
    // with default values.
    public ViewFrame(Account user)
    {
    	this.user = user;
    	Topics topics = Topics.getInstance();
    	
        setTitle("View topics");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        title = new JLabel("View all topics");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 50);
        title.setLocation(250, 25);
        container.add(title);
 
        lsearch = new JLabel("Search topic by ID");
        lsearch.setFont(new Font("Arial", Font.PLAIN, 20));
        lsearch.setSize(300, 50);
        lsearch.setLocation(250, 75);
        container.add(lsearch);
        
        tsearch = new JTextField(searchTip);
        tsearch.setFont(new Font("Arial", Font.PLAIN, 15));
        tsearch.setSize(300, 20);
        tsearch.setLocation(250, 125);
        tsearch.addFocusListener(textFocusListener);
        container.add(tsearch);
 
        search = new JButton("Search");
        search.setFont(new Font("Arial", Font.PLAIN, 20));
        search.setSize(100, 20);
        search.setLocation(550, 125);
        search.addActionListener(this);
        container.add(search);
        
        list = new JList<Topic>(topics.getVector(AllAccount.getInstance()));
        list.setFont(new Font("Arial", Font.PLAIN, 20));
        list.setSize(400, 300);
        list.setLocation(250, 150);
        list.setSelectedIndex(0);
        container.add(list);
 
        select = new JButton("Select");
        select.setFont(new Font("Arial", Font.PLAIN, 15));
        select.setSize(100, 20);
        select.setLocation(250, 500);
        select.addActionListener(this);
        container.add(select);

        back = new JButton("back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(100, 20);
        back.setLocation(550, 500);
        back.addActionListener(this);
        container.add(back);
 
        setVisible(true);
        search.requestFocus();
    }
        
 // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
    	Topics topics = Topics.getInstance();
        if (e.getSource() == search) {
        	String id = tsearch.getText();
        	if(topics.containsKey(id)) {
        		new TopicFrame(user, topics.getTopic(id));
            	this.dispose();
        	}
        	else {
        		message("ID not found");
        	}
        }
        else if (e.getSource() == select) {
        	Topic topic = list.getSelectedValue();
        	if(topic == null) {
        		message("Please select a topic");
        	}
        	else {
            	new TopicFrame(user, topic);
            	this.dispose();
            }
        }
        if (e.getSource() == back) {
        	new MenuFrame(user);
            this.dispose();
        }
    }

	protected void resetTitle(String text) {
		title.setText(text);
	}


	protected void resetList(Vector<Topic> vector) {
        list.setListData(vector);
        list.setSelectedIndex(0);
	}
}
