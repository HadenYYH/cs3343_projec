import java.util.Scanner;

	public class services{
		page page;
		public services() {
			Scanner sc=new Scanner(System.in); 
			String input;
			this.page = new page();
			this.page.welcomePage();
			pressEnterToContinue();
			do {
				this.page.loginMenuPage();
				input = sc.nextLine();
				switch(input) {
				  case "1":
					pressEnterToContinue();
					loginServices();
				    break;
				  case "2":
					pressEnterToContinue();
					registerServices();
				    break;
				  case "3":
					pressEnterToContinue();
					forgetPwServices();
					break;
				  case "4":
					pressEnterToContinue();
					exitServices();
					break;
				  default:
					System.out.println("Invaild input.");
					pressEnterToContinue();
				}
			}while(true);
		}
	
	private void loginServices() {
		
	}
	
	private void registerServices() {
		
	}
	
	private void forgetPwServices() {
		
	}

	private void exitServices() {
		page.exitPage();
		pressEnterToContinue();
		System.exit(0);
	}
		
	private void pressEnterToContinue()
	 { 
		System.out.println();
	    System.out.println("Press Enter key to continue...");
	    try
	    {
	    	System.in.read();
	    }  
	    catch(Exception e){
	    	
	    }
	    clearScreen();
	 }
	
	private void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	} 
}