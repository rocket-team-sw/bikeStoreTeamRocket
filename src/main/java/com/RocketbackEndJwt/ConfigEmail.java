package com.RocketbackEndJwt;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ConfigEmail {
	
	Properties mailServerProperties;
	Session getMailSession;
	MimeMessage generateMailMessage;
	
	public void sendNotification(String user, String password, String email, String url) throws AddressException, MessagingException{
		String body = "Para reestablecer su contraseña porfavor visita la siguiente url"+'\n'+url;
		String title = "Reestablecer contraseña GMBCarteras";
		Preparar(user, email, body, title, password);
	}
	
	public void sendNotification(String user, String password, String mensaje, String email, String cedula, String nombre) throws AddressException, MessagingException{
		String title = "Un usuario ha registrado un cliente sin geolocalización.";
		String body = "El usuario "+nombre+" identificado con documento "+cedula+"\n"+mensaje;
		Preparar(user, email, body, title, password);
	}
	
	private void Preparar(String user, String email, String body, String title, String password) throws AddressException, MessagingException{
		/*propiedades*/
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.host", "smtp.gmail.com");
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		/*end propiedades*/
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(user));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(email));
		generateMailMessage.setSubject(title);
		generateMailMessage.setContent(body, "text/html");
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect(user, password);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}
