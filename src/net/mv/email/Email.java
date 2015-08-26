package net.mv.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {

	public void makeEmail(String mess) throws UnsupportedEncodingException, AddressException, MessagingException{
		
		Properties emailProperties = System.getProperties();
		Session mailSession = Session.getDefaultInstance(emailProperties, null);
		MimeMessage emailMessage = new MimeMessage(mailSession);
		
		/*
	     * 
	     */
		String emailPort = "587";//gmail's smtp port
	
		emailProperties.put("mail.smtp.starttls.enable", "true");
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.host", "smtp.gmail.com");
		emailProperties.put("mail.smtp.EnableSSL.enable","true");
			
		
		String[] toEmails = { "lawrence2032@gmail.com" };
		String emailSubject = "Java Email";
		String emailBody = mess;
		
		
		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}
	
		emailMessage.setSubject(emailSubject);
		//emailMessage.setContent(emailBody, "text/html");//for a html email
		emailMessage.setText(emailBody);// for a text email
		BodyPart eMessage = new MimeBodyPart();
		//Multipart multipart = new MimeMultipart();
		
	    //emailMessage.setContent(multipart);
		
		
		String emailHost = "smtp.gmail.com";
		String fromUser = "lawrencegreen2032";//just the id alone without @gmail.com
		String fromUserEmailPassword = "bnpybgvvuepnswal";
	
		Transport transport = mailSession.getTransport("smtps");
		
		
		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}//end makeEmail()
	
	
	
	
	
}
