package Program;
import java.awt.event.*;

@SuppressWarnings("serial")
public class UserTopicFrame extends ViewFrame implements ActionListener {
	
    public UserTopicFrame(Account user)
    {
    	super(user);
        setTitle("My topics");
        resetTitle("My topics");
        resetList(Topics.getInstance().getVector(user));
    }
}
