import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel sid;
    private JTextField tsid;
    private JLabel pw;
    private JPasswordField tpw;
    private JButton sub;
    private JButton forgetPw;
    private JButton back;
    private JLabel result;
    
 
    // constructor, to initialize the components
    // with default values.
    public LoginFrame()
    {
        setTitle("Login");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        container.add(title);
 
        sid = new JLabel("SID");
        sid.setFont(new Font("Arial", Font.PLAIN, 20));
        sid.setSize(500, 20);
        sid.setLocation(300, 100);
        container.add(sid);
 
        tsid = new JTextField();
        tsid.setFont(new Font("Arial", Font.PLAIN, 15));
        tsid.setSize(300, 20);
        tsid.setLocation(300, 125);
        container.add(tsid);
 
        pw = new JLabel("Password");
        pw.setFont(new Font("Arial", Font.PLAIN, 20));
        pw.setSize(300, 20);
        pw.setLocation(300, 175);
        container.add(pw);
        
        tpw = new JPasswordField();
        tpw.setEchoChar('\u25cf');
        tpw.setFont(new Font("Arial", Font.PLAIN, 15));
        tpw.setSize(400, 20);
        tpw.setLocation(300, 200);
        container.add(tpw);
        
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(200, 30);
        sub.setLocation(300, 250);
        sub.addActionListener(this);
        container.add(sub);
        
        forgetPw = new JButton("forget password");
        forgetPw.setFont(new Font("Arial", Font.PLAIN, 15));
        forgetPw.setSize(200, 30);
        forgetPw.setLocation(300, 300);
        forgetPw.addActionListener(this);
        container.add(forgetPw);
 
        back = new JButton("back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(200, 30);
        back.setLocation(300, 350);
        back.addActionListener(this);
        container.add(back);
        
        result = new JLabel("");
        result.setFont(new Font("Arial", Font.PLAIN, 20));
        result.setSize(500, 20);
        result.setLocation(300, 400);
        container.add(result);
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
        	String sidText = tsid.getText();
        	String pwText = String.valueOf(tpw.getPassword());
        	
        	Account account = new Account();
        	account.login(sidText, pwText);
        	
        	if(account.loggedIn()) {
            	new WelcomeFrame(account);
            	this.dispose();
        	}
        }
        
        else if (e.getSource() == forgetPw) {
        	new ForgetPwFrame();
            this.dispose();
        }
 
        else if (e.getSource() == back) {
        	new SelectionFrame();
            this.dispose();
        }
    }
}