package Program;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class EditPasswordFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel oldPw;
    private JPasswordField toldPw;
    private JLabel pw;
    private JPasswordField tpw;
    private String pwTip = "longer than 8, must contain: upper case, lower case, symbol";
    private JLabel pw2;
    private JPasswordField tpw2;
    private JButton sub;
    private JButton reset;
	private JButton back;
	private Account user;
    
    FocusListener PwFocusListener = new FocusListener() {
        public void focusGained(FocusEvent focusEvent) {
        	JPasswordField src = (JPasswordField)focusEvent.getSource();
        	if((src == tpw) & (String.valueOf(src.getPassword()).equals(pwTip))) {
            	src.setEchoChar('\u25cf');
                src.setText("");
        	}
        }

        public void focusLost(java.awt.event.FocusEvent focusEvent) {
        	JPasswordField src = (JPasswordField)focusEvent.getSource();
        	if((src == tpw) & (src.getPassword().length == 0)) {
        		src.setEchoChar((char)0);
        		src.setText(pwTip);
        	}
        }
    };

	private String message(String message) {
		JOptionPane.showMessageDialog(null, message);
		return message;
	}
    
    // constructor, to initialize the components
    // with default values.
    public EditPasswordFrame(Account user)
    {
    	this.user = user;
    	
        setTitle("Edit password");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        title = new JLabel("Edit password");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 50);
        title.setLocation(250, 25);
        container.add(title);
 
        oldPw = new JLabel("Password");
        oldPw.setFont(new Font("Arial", Font.PLAIN, 20));
        oldPw.setSize(300, 20);
        oldPw.setLocation(250, 175);
        container.add(oldPw);
        
        toldPw = new JPasswordField();
    	toldPw.setEchoChar('\u25cf');
        toldPw.setFont(new Font("Arial", Font.PLAIN, 15));
        toldPw.setSize(500, 20);
        toldPw.setLocation(250, 200);
        container.add(toldPw);
 
        pw = new JLabel("New Password");
        pw.setFont(new Font("Arial", Font.PLAIN, 20));
        pw.setSize(300, 20);
        pw.setLocation(250, 250);
        container.add(pw);
        
        tpw = new JPasswordField(pwTip);
        tpw.setEchoChar((char)0);
        tpw.setFont(new Font("Arial", Font.PLAIN, 15));
        tpw.setSize(500, 20);
        tpw.setLocation(250, 275);
        tpw.addFocusListener(PwFocusListener);
        container.add(tpw);
 
        pw2 = new JLabel("Confirm your password");
        pw2.setFont(new Font("Arial", Font.PLAIN, 20));
        pw2.setSize(300, 20);
        pw2.setLocation(250, 325);
        container.add(pw2);
        
        tpw2 = new JPasswordField();
    	tpw2.setEchoChar('\u25cf');
        tpw2.setFont(new Font("Arial", Font.PLAIN, 15));
        tpw2.setSize(500, 20);
        tpw2.setLocation(250, 350);
        container.add(tpw2);
 
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
        	String sidText = user.getSid();
        	String oldPwText = String.valueOf(toldPw.getPassword());
        	String pwText = String.valueOf(tpw.getPassword());
        	String pw2Text = String.valueOf(tpw2.getPassword());
        	
        	if(message(user.editPw(sidText, oldPwText, pwText, pw2Text)).equals("Password Changed")) {
            	new MenuFrame(user);
            	this.dispose();
        	}
        }
        else if (e.getSource() == reset) {
            //tname.setText("");
            //tsid.setText("");
            //temail.setText(emailTip);
            tpw.setEchoChar((char)0);
            tpw.setText(pwTip);
            tpw2.setText("");
        }
        else if (e.getSource() == back) {
        	new EditAccountFrame(user);
            this.dispose();
        }
    }
}
