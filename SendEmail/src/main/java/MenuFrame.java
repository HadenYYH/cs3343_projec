import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class MenuFrame extends JFrame implements ActionListener {

    // Components of the Form
    private Container container;
    private JLabel title;
	private JButton login;
    private JLabel name;
    private JButton view;
    private JButton create;
    private JButton userTopics;
    private JButton account;
    private JButton exit;
    private Account user;
 
    // constructor, to initialize the components
    // with default values.
    public MenuFrame(Account user) {
    	this.user = user;
    	
        setTitle("Welcome");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        title = new JLabel("Welcome");
        title.setFont(new Font("Arial", Font.PLAIN, 50));
        title.setSize(300, 100);
        title.setLocation(250, 50);
        container.add(title);
 
        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 15));
        login.setSize(300, 50);
        login.setLocation(250, 300);
        login.addActionListener(this);
        container.add(login);
        
        name = new JLabel("Please login");
        name.setFont(new Font("Arial", Font.PLAIN, 30));
        name.setSize(300, 100);
        name.setLocation(250, 100);
        container.add(name);
        
        view = new JButton("View all topics");
        view.setFont(new Font("Arial", Font.PLAIN, 15));
        view.setSize(300, 50);
        view.setLocation(250, 200);
        view.addActionListener(this);
        container.add(view);
 
        create = new JButton("Create topic");
        create.setFont(new Font("Arial", Font.PLAIN, 15));
        create.setSize(300, 50);
        create.setLocation(250, 250);
        create.addActionListener(this);
        container.add(create);
        
        userTopics = new JButton("My topics");
        userTopics.setFont(new Font("Arial", Font.PLAIN, 15));
        userTopics.setSize(300, 50);
        userTopics.setLocation(250, 300);
        userTopics.addActionListener(this);
        container.add(userTopics);
        
        account = new JButton("User account");
        account.setFont(new Font("Arial", Font.PLAIN, 15));
        account.setSize(300, 50);
        account.setLocation(250, 350);
        account.addActionListener(this);
        container.add(account);
 
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.PLAIN, 15));
        exit.setSize(300, 50);
        exit.setLocation(250, 400);
        exit.addActionListener(this);
        container.add(exit);
        
        setVisible(true);
        loggedInVisibility(user.loggedIn());
    }
    
    private void loggedInVisibility(boolean loggedIn) {
    	name.setVisible(loggedIn);
    	if(loggedIn){
        	name.setText(user.getName());
    	}
    	create.setVisible(loggedIn);
    	userTopics.setVisible(loggedIn);
    	account.setVisible(loggedIn);
    	
    	login.setVisible(!loggedIn);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == view) {
        	new ViewFrame(user);
        	this.dispose();
        }
    	else if (e.getSource() == login) {
    		new LoginSelectionFrame();
            this.dispose();
        }
        else if (e.getSource() == create) {
        	new CreateFrame(user);
            this.dispose();
        }
        else if (e.getSource() == userTopics) {
        	new UserTopicFrame(user);
            this.dispose();
        }
        else if (e.getSource() == account) {
        	new UserAccountFrame(user);
            this.dispose();
        }
    	else if (e.getSource() == exit) {
            this.dispose();
        }
    }
}