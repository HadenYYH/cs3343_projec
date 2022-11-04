import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ForgetPwFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel sid;
    private JTextField tsid;
    private JButton sub;
    private JButton back;
    private JLabel result;
    
 
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
        
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(200, 30);
        sub.setLocation(300, 175);
        sub.addActionListener(this);
        container.add(sub);
 
        back = new JButton("back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(200, 30);
        back.setLocation(300, 225);
        back.addActionListener(this);
        container.add(back);
        
        result = new JLabel("");
        result.setFont(new Font("Arial", Font.PLAIN, 20));
        result.setSize(500, 20);
        result.setLocation(300, 275);
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
        	Account user = new Account();
        	if(user.checkForget(sidText)) {
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
