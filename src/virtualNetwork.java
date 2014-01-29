import java.util.Scanner;


public class virtualNetwork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int continua;
		System.out.println("Welcome to the Virtual Mobile Network");
		System.out.println("Enter your Phone number");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		PhoneNumber phone = new PhoneNumber(number);
		System.out.println("You have the following new messages");
		phone.notifications();
		do{
		System.out.println("Choose 1 to send an sms, 2 to view inbox and 3 to view outbox");
		int choice = scan.nextInt();
		if(choice == 1){
			System.out.println("Enter the number to send to");
			number = scan.nextInt();
			System.out.println("Enter the message");
			scan.nextLine();
			String msg = scan.nextLine();
			phone.sendSms(msg, number);
		}
		else if (choice == 2){
			phone.viewInbox();
		}
		else if(choice == 3){
			phone.viewOutbox();
		}
		else{
			System.out.println("Wrong Choice");
		}
		System.out.println("Press 0 to continue using the program");
		continua = scan.nextInt();
		}while(continua == 0);
	}

}
