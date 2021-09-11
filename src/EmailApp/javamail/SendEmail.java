/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * DANISH HUSSAIN
 */
package EmailApp.javamail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
   public static void main(String[] args) {
      // Destinatario della mail
      String to = "daniaccounnt@gmail.com";

      // Mittente della mail
      String from = "danigx202@gmail.com";
      final String username = "Danish Hussian";
      final String password = "*********";

      // Host attraverso il quale manderai la mail
      String host = "smtp.gmail.com";

      // imposto le specifiche per accedere all'host attraverso il quale 
      // manderemo la mail
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Creo l'oggetto sessione per l'autentificazione
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });

      try {
	   // Creo l'oggetto messaggio 
	   Message message = new MimeMessage(session);
	
	   // Set From: imposto il mittente
	   message.setFrom(new InternetAddress(from));
	
	   // Set To: imposto il destinatario
	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));
	
	   // Set Subject: imposto l'oggetto della mail
	   message.setSubject("Testing Subject");
	
	   // Inserisci il testo del messaggio
	   message.setText("Ciao, questa è una prova ma tanto non funziona un...");

	   // Commando di invio
	   Transport.send(message);

	   System.out.println("Messaggio inviato correttamente....");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}