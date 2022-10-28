package Program;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class SelectionFrame extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JButton login;
	private JButton register;
	private JButton exit;
    
    // constructor, to initialize the components
    // with default values.
    public SelectionFrame()
    {
        setTitle("Login Menu Page");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 15));
        login.setSize(300, 50);
        login.setLocation(300, 100);
        login.addActionListener(this);
        c.add(login);
 
        register = new JButton("Register");
        register.setFont(new Font("Arial", Font.PLAIN, 15));
        register.setSize(300, 50);
        register.setLocation(300, 200);
        register.addActionListener(this);
        c.add(register);
 
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.PLAIN, 15));
        exit.setSize(300, 50);
        exit.setLocation(300, 300);
        exit.addActionListener(this);
        c.add(exit);
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
    	if (e.getSource() == login) {
    		LoginFrame f = new LoginFrame();
    	}
    	else if (e.getSource() == register) {
    		RegisterFrame f = new RegisterFrame();
    	}
    	this.dispose();
    }
}