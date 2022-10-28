package Program;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class WelcomeFrame extends JFrame implements ActionListener {

    // Components of the Form
    private Container container;
    private JLabel title;
    private JLabel name;
    private JButton start;
    private Account account;
 
    // constructor, to initialize the components
    // with default values.
    public WelcomeFrame(Account account) {
    	this.account = account;
    	
        setTitle("Welcome");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        title = new JLabel("Welcome");
        title.setFont(new Font("Arial", Font.PLAIN, 50));
        title.setSize(300, 100);
        title.setLocation(300, 100);
        container.add(title);
        
        name = new JLabel(account.getName());
        name.setFont(new Font("Arial", Font.PLAIN, 30));
        name.setSize(300, 100);
        name.setLocation(300, 200);
        container.add(name);
 
        start = new JButton("Start");
        start.setFont(new Font("Arial", Font.PLAIN, 30));
        start.setSize(200, 50);
        start.setLocation(300, 300);
        start.addActionListener(this);
        container.add(start); 
        
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(account.loggedIn()) {
        	//new MenuFrame();
            this.dispose();
    	}
    	else {
        	new SelectionFrame();
            this.dispose();
    	}
    }
}