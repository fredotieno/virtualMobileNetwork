import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class PhoneNumber {
	public String phoneNumber;
	public String inbox;
	public String outbox;
	
	public PhoneNumber(int phoneNo){
		phoneNumber = Integer.toString(phoneNo);
		String no = Integer.toString(phoneNo);
		inbox = no.concat("inbox.txt");
		outbox = no.concat("outbox.txt");
	}
	
	public void sendSms(String msg, int num){
		try {
			String no = Integer.toString(num);
            // Assume default encoding.
            FileWriter fileWriter =  new FileWriter(outbox, true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character
            bufferedWriter.append("To :" + no + " Message: ");
            bufferedWriter.append(msg);
            bufferedWriter.newLine();
            // Always close files.
            bufferedWriter.close();
            
    		String receiverInbox = no.concat("inbox.txt");
    		FileWriter fileWriter2 =  new FileWriter(receiverInbox, true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);

            // Note that write() does not automatically
            // append a newline character
            bufferedWriter2.append("From :"+phoneNumber+ " Message: ");
            bufferedWriter2.append(msg);
            bufferedWriter2.newLine();
            bufferedWriter2.close();
            
            String receiverNotification = no.concat("notification.txt");
            FileWriter fileWriter3 = new FileWriter(receiverNotification, true);
            BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);

            // Note that write() does not automatically
            // append a newline character
            bufferedWriter3.append(msg);
            bufferedWriter3.newLine();
            bufferedWriter3.close();

           
        }
        catch(IOException ex) {
            System.out.println(
                "Error sending message");
            // Or we could just do this:
            // ex.printStackTrace();
        }
	}
	
	public void viewInbox(){
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(inbox);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }	

            // Always close files.
            bufferedReader.close();			
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "You dont have messages in your inbox");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading inbox");					
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
	public void viewOutbox(){
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(outbox);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }	

            // Always close files.
            bufferedReader.close();			
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "You dont have messages in your outbox");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading outbox");
            }					
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        public void notifications(){
            String line = null;
            String notify = phoneNumber.concat("notification.txt");
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = new FileReader(notify);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }	

                // Always close files.
                bufferedReader.close();
                PrintWriter writer = new PrintWriter(notify);
                writer.print("");
                writer.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println(
                    "");				
            }
            catch(IOException ex) {
                System.out.println(
                    "Error reading outbox");					
                // Or we could just do this: 
                // ex.printStackTrace();
            }
            
	}
}
