package com.sendemail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

//	public SendMail() {
//		// TODO buat declare var dan function send mail
//			     
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String to = "vic21zyq@gmail.com";
		String from = "victorcristopher7@gmail.com";
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		
		//setup mail server;
		 properties.put("mail.smtp.host", host);
	     properties.put("mail.smtp.port", "465");
	     properties.put("mail.smtp.ssl.enable", "true");
	     properties.put("mail.smtp.auth", "true");
	
	     Session session =  Session.getInstance(properties, new Authenticator() {
	    	 protected PasswordAuthentication getPasswordAuthentication() {
	             System.out.println("masuk 1");   
	    		 return new PasswordAuthentication(from,"");
	    		// System.out.println("masuk 2");
	    	 }
		});
	     
	    session.setDebug(true);
	    
	    try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("This is the subject line!");
			System.out.println("masuk 3");
			message.setText("This is a message");
			System.out.println("masuk 4");
			System.out.println("sending");
			System.out.println("masuk 5"
					+ "");
			Transport.send(message);
			
			System.out.println("Message send succesfully");
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			
		}

	}

}
