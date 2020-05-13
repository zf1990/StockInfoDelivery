import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class EmailSender {
	private String senderEmail = "stockinfosender@gmail.com"; //Already regsiteredd.
	private String password = "ApiS3nd#r";
	private String Receiver_Email;
	private Properties properties = new Properties(); //This is just like a hashset.
	private String emailMessage = "Please see the attached for your stock information"; //Default email message
	private String subject = "Your Stock Information " + (new Date()).toString();
	private String file_name; //File name to be attached with the email.
	private Session theSession; 
	private Message the_Message; //This is for the the email content
	public boolean SuccessfullySent = false; //A boolean that will be changed once the email is successfully sent.
	
	public EmailSender(String fileName, String receiver_email) {
		file_name = fileName;
		this.Receiver_Email = receiver_email;
		startActions();
				
	}
	
	public EmailSender(String fileName, String receiver_email,String message) {
		file_name = fileName;
		this.emailMessage = message;
		this.Receiver_Email = receiver_email;
		startActions();

	}
	
	private void startActions() {
		configureSessionSetting();
		theSession = startSession();
		the_Message = prepareMessage(theSession);
		SendEmail(the_Message);
	}
	
	public void configureSessionSetting() {
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
	}
	
	public Session startSession() {
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, password);
			}
		});
		
		return session;
	}
	
	
	public void SendEmail(Message msg) {
		try {
			Transport.send(msg);
			SuccessfullySent = true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Message prepareMessage(Session session) {
		Message message = new MimeMessage(session);
		try {
			
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(Receiver_Email));
			message.setSubject(subject);
			
			Multipart emailContent = new MimeMultipart();
			
			//Create the message in the email body
			MimeBodyPart bodyText = new MimeBodyPart();
			bodyText.setText(emailMessage);
			
			//Attach the csv file
			MimeBodyPart csvAttachment = new MimeBodyPart();
			csvAttachment.attachFile(file_name);
			
			emailContent.addBodyPart(bodyText);
			emailContent.addBodyPart(csvAttachment);
			
			message.setContent(emailContent);
			
		} catch (Exception e) {
			StdOut.println("Well crap, some exception happened");
			e.printStackTrace();
		}
		
		return message;		
	}
}
