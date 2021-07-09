package fahrtenbuch.Mail;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class MailTest {
	
	 private static MailTest instance;
	 
	 private MailTest(){}
	    
	    public static MailTest getInstance(){
	        if(instance == null){
	            instance = new MailTest();
	        }
	        return instance;
	    }
	    

	private static Message prepareMessage(Session session, String myAccount, String empfaenger,String betreff,String body) throws Exception{
		Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(myAccount));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(empfaenger));
        message.setSubject(betreff);

        // Multipart-Message ("Wrapper") erstellen
        Multipart multipart = new MimeMultipart();
        // Body-Part setzen:
        BodyPart messageBodyPart = new MimeBodyPart();
        // Textteil des Body-Parts
        messageBodyPart.setText(body);
        // Body-Part dem Multipart-Wrapper hinzufügen
        multipart.addBodyPart(messageBodyPart);
        // Message fertigstellen, indem sie mit dem Multipart-Content ausgestattet wird
        message.setContent(multipart);

        return message;
}

public void sendMail(String betreff,String body, String empfaenger) {

	Properties properties = new Properties();
	properties.put("mail.smtp.auth",  "true");
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port", "587");

	String myAccount = "bootscomputer.segeln@gmail.com";
	String myPassword = "WsvAwbN119";
	//String empfaenger = "timoengelberts@googlemail.com";

   Session session = Session.getInstance(properties, new Authenticator() {
       @Override
       protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication(myAccount, myPassword);
       }
   });

    // Message-Objekt erzeugen und senden!
	try {
		Message message = prepareMessage(session, myAccount, empfaenger, betreff,body);
		Transport.send(message); // E-Mail senden!
		System.out.println("E-Mail erfolgreich versendet!");
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
	
}
