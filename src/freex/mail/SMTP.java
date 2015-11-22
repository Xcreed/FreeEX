package freex.mail;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;
import com.sun.mail.util.MailSSLSocketFactory;

public class SMTP {
	
/*	class GMailAuthenticator extends Authenticator {
	     String user;
	     String pw;
	     public GMailAuthenticator (String username, String password)
	     {
	        super();
	        this.user = username;
	        this.pw = password;
	     }
	    public PasswordAuthentication getPasswordAuthentication()
	    {
	       return new PasswordAuthentication(user, pw);
	    }
	}
*/	
	
/*	public static void main(String args[]) throws Exception {
		
		Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("ale.castrillom97@gmail.com"));;
        msg.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse("ale.castrillom97@gmail.com", false));
        msg.setSubject("Heisann "+System.currentTimeMillis());
        msg.setText("Med vennlig hilsennTov Are Jacobsen");
        msg.setHeader("X-Mailer", "Tov Are's program");
        msg.setSentDate(new Date());
        SMTPTransport t =
            (SMTPTransport)session.getTransport("smtps");
        t.connect("smtp.gmail.com", "ale.castrillom97@gmail.com", "<retratoss1997>");
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        t.close();
    }
*/	
	
	/**
	 * smtp method sends an email using this protocol 
	 * 
	 * @param userFrom Must be a real Gmail account of the sender
	 * @param password The password of the sender
	 * @param userTo The Gmail account of the person you want to send the message
	 * @param subject The subject of the message
	 * @param text The body of the message 
	 */
	public void smtp(String userFrom, String password, String userTo, String subject, String text){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userFrom,password);
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userFrom));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(userTo));
			message.setSubject(subject);
			message.setText(text);
			System.out.println("Sending...");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
