/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ELITEBOOK
 */
public class EmailSender {
    public static void envoyerCode(String destination,String code ){
     final String expediteur ="congemanager@gmail.com";
     final String motdepasse="edhr rlur ofdl vuqi";
     Properties props=new Properties();
     props.put("mail.smtp.connectiontimeout", "10000"); // 10 secondes
     props.put("mail.smtp.timeout", "10000"); // 10 secondes
     props.put("mail.smtp.auth","true");
     props.put("mail.smtp.starttls.enable","true");
     props.put("mail.smtp.host","smtp.gmail.com");
     props.put("mail.smtp.port","587");
     Session session=Session.getInstance(props,new javax.mail.Authenticator() {
       protected PasswordAuthentication getPasswordAuthentication(){
       return new PasswordAuthentication(expediteur,motdepasse);
       }       
     });
     try{
      Message message=new MimeMessage(session);
      message.setFrom(new InternetAddress(expediteur));
      message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destination));
     message.setSubject("Votre code de Verification ");
     message.setText("Bonjour ,\n\n Vous avez recemment demande un code de Verification.\n\n Voici votre code de Verification : "+code+"\n\n Cordialement \n\n L'Equipe de gestion de conges CongeManager");
     Transport.send(message);
     }catch(MessagingException e){
     e.printStackTrace();
     }
    }
    
}
