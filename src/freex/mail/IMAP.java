package freex.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

import com.sun.mail.imap.IMAPFolder;

public class IMAP {
	
	/*public void imap(String user, String password){
		Properties props = System.getProperties();
		props.setProperty("mail.imap.host", "imap.gmail.com");
		props.setProperty("mail.imap.port", "993");
		props.setProperty("mail.imap.connectiontimeout", "5000");
		props.setProperty("mail.imap.timeout", "5000");

		
		try {
			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(user, password);
						}
					});
			Store store = session.getStore("imaps");
			store.connect("imap.gmail.com", user, password);
			if (!store.isConnected()) {
				store.connect();
		    }
			System.out.println("Succeed");
		}catch (NoSuchProviderException e) {
			e.printStackTrace();
		    System.exit(1);
		} catch (MessagingException e) {
		    e.printStackTrace();
		    System.exit(2);
		}
	}*/
	
	
	/**
	 * The imap method allows the access to the user received Gmail messages
	 * 
	 * @param user The Gmail account of the user 
	 * @param password The password of the users Gmail account
	 * @param msgs The amount of messages you want to show
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void imap(String user, String password, int msgs) throws MessagingException, IOException{
		IMAPFolder folder = null;
        Store store = null;
        String subject = null;
        Flag flag = null;
        try{
        	Properties props = System.getProperties();
        	props.setProperty("mail.store.protocol", "imaps");
        	
        	Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(user, password);
						}
					});
        	
        	store = session.getStore("imaps");
        	store.connect("imap.googlemail.com",user, password);
        	
        	//folder = (IMAPFolder) store.getFolder("[Gmail]/Spam"); // This doesn't work for other email account
        	folder = (IMAPFolder) store.getFolder("inbox"); //This works for both email account
        	
        	if(!folder.isOpen())
        	folder.open(Folder.READ_WRITE);
        	Message[] messages = folder.getMessages();
        	System.out.println("No of Messages : " + folder.getMessageCount());
        	System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
        	System.out.println(messages.length);
        	for (int i=messages.length-1; i >= messages.length-msgs;i--){

		        System.out.println("*****************************************************************************");
		        System.out.println("MESSAGE " + (i + 1) + ":");
		        Message msg =  messages[i];
		        //System.out.println(msg.getMessageNumber());
		        //Object String;
		        //System.out.println(folder.getUID(msg)
		
		        subject = msg.getSubject();
		
		        System.out.println("Subject: " + subject);
		        System.out.println("From: " + msg.getFrom()[0]);
		        System.out.println("To: "+msg.getAllRecipients()[0]);
		        System.out.println("Date: "+msg.getReceivedDate());
		        System.out.println("Size: "+msg.getSize());
		        System.out.println(msg.getFlags());
		        System.out.println("Body: \n"+ msg.getContent());
		        System.out.println(msg.getContentType());
	        }
        }
        finally{
        	if (folder != null && folder.isOpen()) { 
        		folder.close(true); 
        	}
        	if (store != null) { 
        		store.close(); 
        	}
        }

    }

	
}
