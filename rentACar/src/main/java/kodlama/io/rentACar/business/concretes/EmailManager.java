package kodlama.io.rentACar.business.concretes;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.EmailService;
import kodlama.io.rentACar.core.entities.User;
@Service
public class EmailManager implements EmailService{
	
	@Override
	public void sendVerifyEmail(User user, String code) {
		String link = "http://localhost:8080/api/activationcode/active/"+code;
		String button = "<a href=" + link +">"
					+ "<button style='background-color:blue;outline:none;border:none;border-radius:1rem;color:white;padding:.75rem 1rem'>Onayla</button>"
				+ "</a> ";
		
		String host = "smtp.gmail.com";
		int port = 587;
		String email = "developeraey37@gmail.com";
		String password = "bgtgjnmqbfonewpv";
        String messageTxt = "Rent A Car kayıt işleminizi tamamlamak için butona tıklayınız <br/> <br/>" + button;
        
		Properties prop =  new Properties();
		
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
	    prop.put("mail.smtp.host", host);
	    prop.put("mail.smtp.port", Integer.toString( port ));
	    prop.put("mail.smtp.ssl.trust", host);
	        
	    try {
	    Session session = Session.getInstance(prop, new Authenticator() {
	           @Override
	           protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(email, password);
	           }
	     });
	        
	    
	    
	   
	  
	    	Message message = new MimeMessage(session);
	    	message.setSubject("HRMS Mail Dogrulama");
	  
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
	        message.setFrom(new InternetAddress(email));
	        

	        MimeBodyPart mimeBodyPartWithStyledText = new MimeBodyPart();
	        mimeBodyPartWithStyledText.setContent(messageTxt, "text/html; charset=utf-8");
	        
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(mimeBodyPartWithStyledText);
	        
	        message.setContent(multipart);
	        
	        Transport.send(message);
	        
	    }catch(Exception e) {
	    	
	    }
	   
	       
	        
		
	}

	@Override
	public void sendConfirmCode(User user, String code) {
		
		String host = "smtp.gmail.com";
		int port = 587;
		String email = "developeraey37@gmail.com";
		String password = "bgtgjnmqbfonewpv";
        String messageTxt = "Rent A Car şifre yenileme işleminizi tamamlamak için aşağıdaki kodu giriniz <br/> <br/>" + code;
        
		Properties prop =  new Properties();
		
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
	    prop.put("mail.smtp.host", host);
	    prop.put("mail.smtp.port", Integer.toString( port ));
	    prop.put("mail.smtp.ssl.trust", host);
	        
	    try {
	    Session session = Session.getInstance(prop, new Authenticator() {
	           @Override
	           protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(email, password);
	           }
	     });
	        
	    
	    
	   
	  
	    	Message message = new MimeMessage(session);
	    	message.setSubject("Rent A Car Mail Dogrulama");
	  
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
	        message.setFrom(new InternetAddress(email));
	        

	        MimeBodyPart mimeBodyPartWithStyledText = new MimeBodyPart();
	        mimeBodyPartWithStyledText.setContent(messageTxt, "text/html; charset=utf-8");
	        
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(mimeBodyPartWithStyledText);
	        
	        message.setContent(multipart);
	        
	        Transport.send(message);
	        
	    }catch(Exception e) {
	    	
	    }
	   
	       
		
	}
}
