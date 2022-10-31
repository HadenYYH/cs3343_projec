import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class UserAccountFrame extends JFrame implements ActionListener {
	// Components of the Form
    private Container container;
    private JLabel title;
    private JLabel name;
    private JLabel tname;
    private JLabel sid;
    private JLabel tsid;
    private JLabel email;
    private JLabel temail;
    private JLabel pw;
    private JLabel tpw;
    private JButton edit;
    private JButton logout;
	private JButton back;
    private Account user;
    
    // constructor, to initialize the components
    // with default values.
    public UserAccountFrame(Account user)
    {
    	this.user = user;
    	
        setTitle("Account");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        container = getContentPane();
        container.setLayout(null);
 
        title = new JLabel("User Account");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 50);
        title.setLocation(250, 25);
        container.add(title);
 
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(250, 100);
        container.add(name);
 
        tname = new JLabel(user.getName());
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(100, 20);
        tname.setLocation(250, 125);
        container.add(tname);
 
        sid = new JLabel("SID");
        sid.setFont(new Font("Arial", Font.PLAIN, 20));
        sid.setSize(100, 20);
        sid.setLocation(450, 100);
        container.add(sid);
 
        tsid = new JLabel(user.getSid());
        tsid.setFont(new Font("Arial", Font.PLAIN, 15));
        tsid.setSize(100, 20);
        tsid.setLocation(450, 125);
        container.add(tsid);
 
        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(500, 20);
        email.setLocation(250, 175);
        container.add(email);
 
        temail = new JLabel(user.getEmail());
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(300, 20);
        temail.setLocation(250, 200);
        container.add(temail);
 
        pw = new JLabel("Password");
        pw.setFont(new Font("Arial", Font.PLAIN, 20));
        pw.setSize(300, 20);
        pw.setLocation(250, 250);
        container.add(pw);
        
        tpw = new JLabel("Password is hidden");
        tpw.setFont(new Font("Arial", Font.PLAIN, 15));
        tpw.setSize(400, 20);
        tpw.setLocation(250, 275);
        container.add(tpw);
 
        edit = new JButton("edit");
        edit.setFont(new Font("Arial", Font.PLAIN, 15));
        edit.setSize(100, 20);
        edit.setLocation(250, 425);
        edit.addActionListener(this);
        container.add(edit);
 
        logout = new JButton("logout");
        logout.setFont(new Font("Arial", Font.PLAIN, 15));
        logout.setSize(100, 20);
        logout.setLocation(400, 425);
        logout.addActionListener(this);
        container.add(logout);
 
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
        if (e.getSource() == edit) {
        	new EditAccountFrame(user);
        	this.dispose();
        }
        else if (e.getSource() == logout) {
        	user.logout();
        	new LoginSelectionFrame();
        	this.dispose();
        }
        else if (e.getSource() == back) {
        	new MenuFrame(user);
        	this.dispose();
        }
    }
}
