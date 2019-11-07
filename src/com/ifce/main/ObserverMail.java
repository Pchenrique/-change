package com.ifce.main;

import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Paulo Cesar
 */
public class ObserverMail implements Observer{
    
    final String username = "Email_utilizado";
    final String password = "Senha_do_email";
    
    @Override
    public void update(Observable o, Object arg) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username,password);
                }
            });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mesmo email do username"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("Email do destinatario"));
            //Monte sua mensagem
            message.setSubject("Noticia");
            message.setText("O site do IF teve alterações" +
                    "\n\n Att, Equipe APSI!");

            Transport.send(message);

            System.out.println("Email enviado");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
