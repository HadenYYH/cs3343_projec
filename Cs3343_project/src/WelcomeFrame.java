import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class WelcomeFrame extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JButton start;
 
    // constructor, to initialize the components
    // with default values.
    public WelcomeFrame() {
        setTitle("Welcome");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("Welcome");
        title.setFont(new Font("Arial", Font.PLAIN, 50));
        title.setSize(300, 100);
        title.setLocation(300, 100);
        c.add(title);
 
        start = new JButton("Start");
        start.setFont(new Font("Arial", Font.PLAIN, 30));
        start.setSize(200, 50);
        start.setLocation(300, 300);
        start.addActionListener(this);
        c.add(start); 
        
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    @Override
    public void actionPerformed(ActionEvent e) {
    	SelectionFrame f = new SelectionFrame();
        this.dispose();
    }
}