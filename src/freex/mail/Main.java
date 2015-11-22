package freex.mail;

public class Main {
	
	
	public static void main(String args[]) throws Exception {
		String gmailAccountFrom = "abc@gmail.com";
		String password = "password";
		String gmailAccountTo = "xyz@gmail.com";
		String subject = "Subject";
		String text = "Body of the message HERE";
		
		//SMTP test
		SMTP smtp = new SMTP();
		smtp.smtp(gmailAccountFrom, password, gmailAccountTo, subject, text);
		//IMAP test
		IMAP imap = new IMAP();
		imap.imap(gmailAccountFrom, password, 2);
	}
	
}
