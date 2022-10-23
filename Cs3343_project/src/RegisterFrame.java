import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class RegisterFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel sid;
    private JTextField tsid;
    private JLabel email;
    private JTextField temail;
    private String emailTip = "must be cityu student email";
    private JLabel pw;
    private JPasswordField tpw;
    private String pwTip = "must contain: upper case, lower case, symbol";
    private JLabel pw2;
    private JPasswordField tpw2;
    private JButton sub;
    private JButton reset;
	private JButton back;
    private JLabel result;
    
    FocusListener textFocusListener = new FocusListener() {
        public void focusGained(FocusEvent focusEvent) {
        	JTextField src = (JTextField)focusEvent.getSource();
        	if((src == temail) & (src.getText().equals(emailTip))) {
                src.setText("");
        	}
        }

        public void focusLost(java.awt.event.FocusEvent focusEvent) {
        	JTextField src = (JTextField)focusEvent.getSource();
        	if((src == temail) & (src.getText().isEmpty())) {
        		src.setText(emailTip);
        	}
        }
    };
    
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
    
    // constructor, to initialize the components
    // with default values.
    public RegisterFrame()
    {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 50);
        title.setLocation(300, 25);
        c.add(title);
 
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(300, 100);
        c.add(name);
 
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(100, 20);
        tname.setLocation(300, 125);
        c.add(tname);
 
        sid = new JLabel("SID");
        sid.setFont(new Font("Arial", Font.PLAIN, 20));
        sid.setSize(100, 20);
        sid.setLocation(450, 100);
        c.add(sid);
 
        tsid = new JTextField();
        tsid.setFont(new Font("Arial", Font.PLAIN, 15));
        tsid.setSize(100, 20);
        tsid.setLocation(450, 125);
        c.add(tsid);
 
        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(500, 20);
        email.setLocation(300, 175);
        c.add(email);
 
        temail = new JTextField(emailTip);
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(300, 20);
        temail.setLocation(300, 200);
        temail.addFocusListener(textFocusListener);
        c.add(temail);
 
        pw = new JLabel("Password");
        pw.setFont(new Font("Arial", Font.PLAIN, 20));
        pw.setSize(300, 20);
        pw.setLocation(300, 250);
        c.add(pw);
        
        tpw = new JPasswordField(pwTip);
        tpw.setEchoChar((char)0);
        tpw.setFont(new Font("Arial", Font.PLAIN, 15));
        tpw.setSize(400, 20);
        tpw.setLocation(300, 275);
        tpw.addFocusListener(PwFocusListener);
        c.add(tpw);
 
        pw2 = new JLabel("Confirm your password");
        pw2.setFont(new Font("Arial", Font.PLAIN, 20));
        pw2.setSize(300, 20);
        pw2.setLocation(300, 325);
        c.add(pw2);
        
        tpw2 = new JPasswordField();
    	tpw2.setEchoChar('\u25cf');
        tpw2.setFont(new Font("Arial", Font.PLAIN, 15));
        tpw2.setSize(400, 20);
        tpw2.setLocation(300, 350);
        c.add(tpw2);
 
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(300, 425);
        sub.addActionListener(this);
        c.add(sub);
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(450, 425);
        reset.addActionListener(this);
        c.add(reset);
 
        back = new JButton("back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(100, 20);
        back.setLocation(600, 425);
        back.addActionListener(this);
        c.add(back);
        
        result = new JLabel("");
        result.setFont(new Font("Arial", Font.PLAIN, 15));
        result.setSize(500, 20);
        result.setLocation(300, 475);
        c.add(result);
 
        setVisible(true);
    }
        
 // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
        	String sid_text = tsid.getText();
        	String name_text = tname.getText();
        	String pw_text = String.valueOf(tpw.getPassword());
        	String pw2_text = String.valueOf(tpw2.getPassword());
        	String email_text = temail.getText();
        	
        	SidandPw sidandPw = SidandPw.getInstance();
        	Services services = new Services();
        	
        	boolean sid_valid = (sid_text.length() == 8) & sid_text.matches("[0-9]+");
        	String sid_exist = services.getUserDataBySid(sid_text);
    		boolean pw_long_enough = (pw_text.length() >= 8);
        	boolean pw_upper_case = pw_text.matches(".*[A-Z].*");
        	boolean pw_lower_case = pw_text.matches(".*[a-z].*");
        	boolean pw_symbol = pw_text.matches(".*[^\\w].*");
        	boolean pw_no_comma = !pw_text.matches(".*[,].*");
        	boolean pw2_correct = pw_text.equals(pw2_text);
        	boolean email_valid = email_text.endsWith("@my.cityu.edu.hk");

        	String hashed_pw = "";
        	ArrayList<String> file_list = services.getALLTextFileInDirectory();
        	
        	if (!sid_valid) {
            	result.setText("Invalid sid");
            }
        	else if(sid_exist!=null) {
        		result.setText("This SID was registered");
        	}
            else if (!email_valid) {
            	result.setText("Invalid email");
            }
            else if (!pw_long_enough) {
            	result.setText("Password must be longer than 8 chracters");
            }
            else if (!pw_upper_case) {
            	result.setText("Password must contain an upper case letter");
            }
            else if (!pw_lower_case) {
            	result.setText("Password must contain an lower case letter");
            }
            else if (!pw_symbol) {
            	result.setText("Password must contain a non-letter symbol");
            }
            else if (!pw_no_comma) {
            	result.setText("Password must not contain a comma");
            }
            else if (!pw2_correct) {
            	result.setText("Two passwords are different");
            }
            else if(name_text.length()>15) {
            	result.setText("Username too long");
            }
            else if(services.checkEmail(email_text, file_list)){
            	result.setText("Email already used");
            	
            }
            else{
            	
				try {
					hashed_pw = services.getHashPw(sid_exist, pw_text);
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
            	services.writeUserData(sid_text, name_text, email_text, hashed_pw);
            	SidandPw s = SidandPw.getInstance();
            	s.put(tsid.getText(), new String(tpw.getPassword()));
            	s.get(sid_text);
            	result.setText("Login successful!");
            }
            
        }
        else if (e.getSource() == reset) {
            tname.setText("");
            tsid.setText("");
            temail.setText(emailTip);
            tpw.setEchoChar((char)0);
            tpw.setText(pwTip);
            tpw2.setText("");
        }
        else if (e.getSource() == back) {
        	SelectionFrame f = new SelectionFrame();
            this.dispose();
        }
    }
}
