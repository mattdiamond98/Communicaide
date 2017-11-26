package com.gmail.mattdiamond98.communicaide.platforms;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.gmail.mattdiamond98.communicaide.contact.Contact;
import com.gmail.mattdiamond98.communicaide.message.MessageDetails;
import com.gmail.mattdiamond98.communicaide.services.AuthenticationService;

public class EmailPlatform implements Platform {
	
	/**
	 * NOTE: This functions only for gmail at the moment
	 */
	@Override
	public void sendMessage(MessageDetails messageDetails, Contact to) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(
						AuthenticationService.getEmailUsername(),
						AuthenticationService.getEmailPassword());
			}
		  });
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(AuthenticationService.getEmailUsername()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to.getPlatformValue(PlatformType.EMAIL)));
			message.setSubject(messageDetails.getSubject());
			message.setText(messageDetails.getText());
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
