package Program;

public final class AllAccount extends Account {
	private static final AllAccount instance = new AllAccount();

	private AllAccount() {
		super(null, null, null, null);
	}
	
	public static AllAccount getInstance() {
	    return instance;
	}

	@Override
	public boolean checkUser(Account user) {
		return true;
	}
}