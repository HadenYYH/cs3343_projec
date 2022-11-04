import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class LoginSelectionFrame extends JFrame implements ActionListener {

    // Components of the Form
    private Container container;
    private JButton login;
	private JButton register;
	private JButton back;
    
    // constructor, to initialize the components
    // with default values.
    public LoginSelectionFrame()
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
        login.setLocation(250, 100);
        login.addActionListener(this);
        container.add(login);
 
        register = new JButton("Register");
        register.setFont(new Font("Arial", Font.PLAIN, 15));
        register.setSize(300, 50);
        register.setLocation(250, 200);
        register.addActionListener(this);
        container.add(register);
 
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(300, 50);
        back.setLocation(250, 300);
        back.addActionListener(this);
        container.add(back);
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
    	if (e.getSource() == login) {
    		new LoginFrame();
        	this.dispose();
    	}
    	else if (e.getSource() == register) {
    		new RegisterFrame();
        	this.dispose();
    	}
    	else if (e.getSource() == back) {
    		new MenuFrame(null);
        	this.dispose();
    	}
    }
}