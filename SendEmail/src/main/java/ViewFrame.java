import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel lsearch;
    private JTextField tsearch;
	private JButton search;
    private String searchTip = "Topic ID is consist of 8 digits";
    
    private JList<Topic> list;

	private JButton view;
	private JButton back;
	private Account user;
	
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
    	
        setTitle("Create topic");
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
        
        list = new JList<Topic>(topics.getVector());
        list.setFont(new Font("Arial", Font.PLAIN, 20));
        list.setSize(400, 300);
        list.setLocation(250, 150);
        list.setSelectedIndex(1);
        container.add(list);
 
        view = new JButton("View");
        view.setFont(new Font("Arial", Font.PLAIN, 15));
        view.setSize(100, 20);
        view.setLocation(250, 500);
        view.addActionListener(this);
        container.add(view);

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
        		JOptionPane.showMessageDialog(null, "ID not found");
        	}
        }
        else if (e.getSource() == view) {
        	Topic topic = list.getSelectedValue();
        	new TopicFrame(user, topic);
        	this.dispose();
        }
        if (e.getSource() == back) {
        	new MenuFrame(user);
            this.dispose();
        }
    }
}
