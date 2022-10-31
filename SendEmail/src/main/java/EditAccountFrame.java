import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditAccountFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel sid;
    private JTextField tsid;
    private JLabel email;
    private JTextField temail;
    private JLabel pw;
    private JPasswordField tpw;
    private JButton sub;
    private JButton reset;
	private JButton editPassword;
	private JButton back;
	private Account user;
    
    // constructor, to initialize the components
    // with default values.
    public EditAccountFrame(Account user)
    {
    	this.user = user;
        setTitle("Edit account");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        title = new JLabel("Edit form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 50);
        title.setLocation(250, 25);
        container.add(title);
 
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(250, 100);
        container.add(name);
 
        tname = new JTextField(user.getName());
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(100, 20);
        tname.setLocation(250, 125);
        container.add(tname);
 
        sid = new JLabel("SID");
        sid.setFont(new Font("Arial", Font.PLAIN, 20));
        sid.setSize(100, 20);
        sid.setLocation(450, 100);
        container.add(sid);
 
        tsid = new JTextField(user.getSid());
        tsid.setFont(new Font("Arial", Font.PLAIN, 15));
        tsid.setSize(100, 20);
        tsid.setLocation(450, 125);
        container.add(tsid);
 
        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(500, 20);
        email.setLocation(250, 175);
        container.add(email);
 
        temail = new JTextField(user.getEmail());
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(300, 20);
        temail.setLocation(250, 200);
        container.add(temail);
 
        pw = new JLabel("Password");
        pw.setFont(new Font("Arial", Font.PLAIN, 20));
        pw.setSize(300, 20);
        pw.setLocation(250, 250);
        container.add(pw);
        
        tpw = new JPasswordField();
    	//tpw2.setEchoChar('\u25cf');
        tpw.setFont(new Font("Arial", Font.PLAIN, 15));
        tpw.setSize(400, 20);
        tpw.setLocation(250, 275);
        container.add(tpw);
 
        sub = new JButton("submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(150, 20);
        sub.setLocation(250, 375);
        sub.addActionListener(this);
        container.add(sub);
 
        reset = new JButton("reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(150, 20);
        reset.setLocation(425, 375);
        reset.addActionListener(this);
        container.add(reset);
 
        editPassword = new JButton("edit password");
        editPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        editPassword.setSize(150, 20);
        editPassword.setLocation(250, 425);
        editPassword.addActionListener(this);
        container.add(editPassword);
 
        back = new JButton("back");
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        back.setSize(150, 20);
        back.setLocation(425, 425);
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
        	String sidText = tsid.getText();
        	String emailText = temail.getText();
        	String pwText = String.valueOf(tpw.getPassword());
        	
        	if(user.edit(sidText, nameText, emailText, pwText)) {
            	new MenuFrame(user);
            	this.dispose();
        	}
        }
        else if (e.getSource() == reset) {
            tname.setText(user.getName());
            tsid.setText(user.getSid());
            temail.setText(user.getEmail());
            tpw.setText("");
        }
        else if (e.getSource() == editPassword) {
        	new EditPasswordFrame(user);
            this.dispose();
        }
        else if (e.getSource() == back) {
        	new UserAccountFrame(user);
            this.dispose();
        }
    }
}
