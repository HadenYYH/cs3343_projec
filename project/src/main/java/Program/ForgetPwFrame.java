package Program;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ForgetPwFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel sid;
    private JTextField tsid;
    private JLabel email;
    private JTextField temail;
    private JButton sub;
    private JButton back;

	private String message(String message) {
		JOptionPane.showMessageDialog(null, message);
		return message;
	}    
 
    // constructor, to initialize the components
    // with default values.
    public ForgetPwFrame()
    {
        setTitle("Login");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        title = new JLabel("Forget Password");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(250, 30);
        container.add(title);
 
        sid = new JLabel("SID");
        sid.setFont(new Font("Arial", Font.PLAIN, 20));
        sid.setSize(500, 20);
        sid.setLocation(250, 100);
        container.add(sid);
 
        tsid = new JTextField();
        tsid.setFont(new Font("Arial", Font.PLAIN, 15));
        tsid.setSize(300, 20);
        tsid.setLocation(250, 125);
        container.add(tsid);
 
        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(500, 20);
        email.setLocation(250, 175);
        container.add(email);
 
        temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(300, 20);
        temail.setLocation(250, 200);
        container.add(temail);
        
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(200, 30);
        sub.setLocation(250, 250);
        sub.addActionListener(this);
        container.add(sub);
 
        back = new JButton("back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(200, 30);
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
        if (e.getSource() == sub) {
        	String sidText = tsid.getText();
        	String emailText = temail.getText();
        	if(message(Accounts.getInstance().checkForget(sidText, emailText)).equals("A temporary password has been sent to your email\nPlease login again")) {
        		new LoginFrame();
            	this.dispose();
        	}
        }
 
        else if (e.getSource() == back) {
        	new LoginFrame();
            this.dispose();
        }
    }
}
