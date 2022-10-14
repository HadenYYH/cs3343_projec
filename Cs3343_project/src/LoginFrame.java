import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class LoginFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container c;
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
 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
 
        sid = new JLabel("Student ID");
        sid.setFont(new Font("Arial", Font.PLAIN, 20));
        sid.setSize(500, 20);
        sid.setLocation(300, 100);
        c.add(sid);
 
        tsid = new JTextField();
        tsid.setFont(new Font("Arial", Font.PLAIN, 15));
        tsid.setSize(300, 20);
        tsid.setLocation(300, 125);
        c.add(tsid);
 
        pw = new JLabel("Password");
        pw.setFont(new Font("Arial", Font.PLAIN, 20));
        pw.setSize(300, 20);
        pw.setLocation(300, 175);
        c.add(pw);
        
        tpw = new JPasswordField();
        tpw.setEchoChar((char)0);
        tpw.setFont(new Font("Arial", Font.PLAIN, 15));
        tpw.setSize(400, 20);
        tpw.setLocation(300, 200);
        c.add(tpw);
        
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(200, 30);
        sub.setLocation(300, 250);
        sub.addActionListener(this);
        c.add(sub);
        
        forgetPw = new JButton("forget password");
        forgetPw.setFont(new Font("Arial", Font.PLAIN, 15));
        forgetPw.setSize(200, 30);
        forgetPw.setLocation(300, 300);
        forgetPw.addActionListener(this);
        c.add(forgetPw);
 
        back = new JButton("back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(200, 30);
        back.setLocation(300, 350);
        back.addActionListener(this);
        c.add(back);
        
        result = new JLabel("");
        result.setFont(new Font("Arial", Font.PLAIN, 20));
        result.setSize(100, 20);
        result.setLocation(300, 400);
        c.add(result);
 
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
        	SidandPw sidandPw = SidandPw.getInstance();
        	
        	boolean sidValid = (sidText.length() == 8) & sidText.matches("[0-9]+");
        	boolean sidExist = sidandPw.containsKey(sidText);
        	boolean pwCorrect = pwText.equals(sidandPw.get(sidText));
        	
            if (!sidValid) {
            	result.setText("Invalid SID");
            }
            else if (!sidExist) {
            	result.setText("Wrong SID or password");
            }
            else if (!pwCorrect) {
            	result.setText("Wrong SID or password");
            }
            else {
            	result.setText("Login successful!");
            }
        }
        
        else if (e.getSource() == forgetPw) {
        	//ForgetPwFrame f = new ForgetPwFrame();
            this.dispose();
        }
 
        else if (e.getSource() == back) {
        	SelectionFrame f = new SelectionFrame();
            this.dispose();
        }
    }
}
