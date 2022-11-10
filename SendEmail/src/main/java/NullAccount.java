
public final class NullAccount extends Account {
	private static final NullAccount instance = new NullAccount(null, null, null, null);

	private NullAccount(String sid, String name, String email, String pw) {
		super(sid, name, email, pw);
	}
	
	public static NullAccount getInstance() {
	    return instance;
	  }

	@Override
	public boolean checkCreator(Account user) {
		return true;
	}
}
