package MadhaviPractice.SeleniumwithCucumberPages;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

public class EmailUtils {
	
	public EmailUtils()
	{
		
	}
	
	public static void sendEmail(Session session, String filePath, String email, String subject, String body) {
		try {
			
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/html; charset=utf-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8-bit");
			msg.setFrom(new InternetAddress ("from Address", "DoNotReply"));
			msg.setReplyTo(InternetAddress.parse("from Address", false));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setSentDate(new Date());
			Set<InternetAddress> toInternetAddress = new HashSet();
			toInternetAddress.add(new InternetAddress(email));
			msg.addRecipients(RecipientType.TO,  (Address[])toInternetAddress.toArray(new Address[toInternetAddress.size()]));
			System.out.println("Message is ready");
			Multipart multipart = new MimeMultipart();
			BodyPart messageBody = new MimeBodyPart();
			messageBody.setText(body);
			BodyPart attachments = new MimeBodyPart();
			File file = new File(filePath);
			DataSource source = new FileDataSource(file);
			attachments.setDataHandler(new DataHandler(source));
			attachments.setFileName(file.getName());
			multipart.addBodyPart(attachments);
			multipart.addBodyPart(messageBody);
			msg.setContent(multipart);
			Transport.send(msg);
			System.out.println("Email Sent successfully");
			
			
			
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
