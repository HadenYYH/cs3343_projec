import java.util.Random;

public class RandomPw {
	private static RandomPw instance = new RandomPw();
	
	public static RandomPw getInstance(){
    	return instance;
    }
	
	public String randomPw() {
		int leftLimit = 65; // 'A'
	    int rightLimit = 90; // 'Z'
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(9);
	    int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
		buffer.append((char) randomLimitedInt);
		
		leftLimit = 97; // 'a'
	    rightLimit = 122; // 'z'
	    randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
		buffer.append((char) randomLimitedInt);
	    
		leftLimit = 48; // '0'
	    rightLimit = 57; // '9'
	    int targetStringLength = 6;
	    for (int i = 0; i < targetStringLength; i++) {
	        randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    
	    leftLimit = 33; // '!'
	    rightLimit = 43; // '+'
	    randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
		buffer.append((char) randomLimitedInt);
		
	    String generatedString = buffer.toString();

	    return generatedString;
	}
}
