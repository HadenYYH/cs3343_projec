import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CreateFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel description;
    private JTextArea tdescription;
    private JButton sub;
    private JButton reset;
	private JButton back;
	private Account user;
	
    // constructor, to initialize the components
    // with default values.
    public CreateFrame(Account user)
    {
    	this.user = user;
    	
        setTitle("Create topic");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        title = new JLabel("Registration form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 50);
        title.setLocation(250, 25);
        container.add(title);
 
        name = new JLabel("Topic Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(300, 20);
        name.setLocation(250, 100);
        container.add(name);
 
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(300, 20);
        tname.setLocation(250, 125);
        container.add(tname);
 
        description = new JLabel("Topic description");
        description.setFont(new Font("Arial", Font.PLAIN, 20));
        description.setSize(300, 20);
        description.setLocation(250, 175);
        container.add(description);
 
        tdescription = new JTextArea();
        tdescription.setFont(new Font("Arial", Font.PLAIN, 15));
        tdescription.setSize(300, 200);
        tdescription.setLocation(250, 200);
        tdescription.setLineWrap(true);
        tdescription.setWrapStyleWord(true);
        container.add(tdescription);
 
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(250, 425);
        sub.addActionListener(this);
        container.add(sub);
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(400, 425);
        reset.addActionListener(this);
        container.add(reset);
 
        back = new JButton("back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(100, 20);
        back.setLocation(550, 425);
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
        	
        	if(Topics.getInstance().createTopic(user, nameText, descriptionText)) {
        		new MenuFrame(user);
                this.dispose();
        	}
        }
        else if (e.getSource() == reset) {
            tname.setText("");
            tdescription.setText("");
        }
        else if (e.getSource() == back) {
        	new MenuFrame(user);
            this.dispose();
        }
    }
}
