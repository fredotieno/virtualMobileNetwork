
public class virtualNetwork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneNumber phone = new PhoneNumber(111);
		phone.notifications();
		phone.sendSms("Heloo", 123);
		phone.viewInbox();
		phone.viewOutbox();
	}

}
