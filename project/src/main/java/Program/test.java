package Program;

public class test {
	public static void main(String[] args) {
		new TopicFrame(Accounts.getInstance().getAccount("12345678"), Topics.getInstance().getTopic("00000000"));
	}
}
