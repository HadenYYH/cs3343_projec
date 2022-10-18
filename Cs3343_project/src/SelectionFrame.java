import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class SelectionFrame extends JFrame implements ActionListener {

    // Components of the Form
    private Container container;
    private JButton login;
	private JButton register;
	private JButton exit;
    
    // constructor, to initialize the components
    // with default values.
    public SelectionFrame()
    {
        setTitle("Selection Page");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 15));
        login.setSize(300, 50);
        login.setLocation(300, 100);
        login.addActionListener(this);
        container.add(login);
 
        register = new JButton("Register");
        register.setFont(new Font("Arial", Font.PLAIN, 15));
        register.setSize(300, 50);
        register.setLocation(300, 200);
        register.addActionListener(this);
        container.add(register);
 
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.PLAIN, 15));
        exit.setSize(300, 50);
        exit.setLocation(300, 300);
        exit.addActionListener(this);
        container.add(exit);
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
    	if (e.getSource() == login) {
    		new LoginFrame();
    	}
    	else if (e.getSource() == register) {
    		new RegisterFrame();
    	}
    	this.dispose();
    }
}