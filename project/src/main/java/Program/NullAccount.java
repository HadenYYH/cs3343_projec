package Program;

public final class NullAccount extends Account {
	private static final NullAccount instance = new NullAccount();

	private NullAccount() {
		super(null, null, null, null);
	}
	
	public static NullAccount getInstance() {
	    return instance;
	}
}
