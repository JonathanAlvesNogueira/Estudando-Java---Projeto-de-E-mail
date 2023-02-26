package enviar_email_simples;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Controller {
	
	public void enviarEmail() {
		
		 // Configuração das propriedades do email, coisas padrões e obrigatorias
		Scanner scan = new Scanner(System.in);
		String host = "smtp.gmail.com"; 
        String port = "587";   
        
        
        System.out.println("Informe o seu email");
        String userName = scan.nextLine();
        System.out.println("Informe seu email a sua senha segura (necessaria configurar o gmail) ");
        String password = scan.nextLine(); 
        System.out.println("Informe o email da pessoa que receberá o email");
        String toAddress = scan.nextLine(); 
        System.out.println("informe o assunto");
        String subject = scan.nextLine();; 

        // Criação da sessão do email, com as propriedades, chave e valor
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        
        // cria sessão e valiada o email
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
          });

        
        
        try {
            // Criação do objeto MimeMessage para representar o email
            Message message = new MimeMessage(session);  // Aqui, estamos configurando o remetente do email, que é o endereço de email que será usado para enviar a mensagem
            message.setFrom(new InternetAddress(userName));
            
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress)); //  Esta linha define o destinatário do email.
            message.setSubject(subject); //Esta linha define o assunto do email.

            // CRIAÇÃO DO CONTEUDO DO EMAIL
            BodyPart messageBodyPart = new MimeBodyPart();   // Nestas linhas, estamos criando uma parte do corpo do email que será adicionada ao email como texto simples.
            System.out.println("Digite o texto que deseja enviar");
            String texto = scan.nextLine();
            messageBodyPart.setText(texto);

            Multipart multipart = new MimeMultipart(); //criando um objeto Multipart, que é usado para armazenar as diferentes partes do email (texto, imagem, etc.) 
            multipart.addBodyPart(messageBodyPart);    // Aqui, estamos adicionando a parte de texto que acabamos de criar.   
 
         /*
            
           // ANEXANDO A IMAGEM
            messageBodyPart = new MimeBodyPart();               // criando uma nova parte do corpo do email que será usada para enviar a imagem. 
            String fileName = "Downloads/imagem.jpg";               // caminho da mensagem
           DataSource source = new FileDataSource(new File(fileName));  // Aqui, estamos criando um objeto FileDataSource para a imagem e adicionando-o como anexo ao email.
          messageBodyPart.setDataHandler(new DataHandler(source));       
            messageBodyPart.setFileName("imagem.jpg"); // dando nome para a imagem
            multipart.addBodyPart(messageBodyPart);    // adicionando ela no multipart

*/
 
            message.setContent(multipart);              // Adiciona as partes ao conteúdo do email
            Transport.send(message);    // Envia o email
            System.out.println("Email enviado com sucesso!");
            

        } catch (MessagingException e) {
            System.err.println("Esse foi o erro" + e.getMessage());
        }
       
      
        
	}
	
	public String gravarEmailMandado(String names) {
		
		
		// Configuração das propriedades do email, coisas padrões e obrigatorias
		Scanner scan = new Scanner(System.in);
        String host = "smtp.gmail.com"; // host obrigatorio para enviar o email
        String port = "587";   // porta obrigatoria do email
        
        
        System.out.println("Informe o seu email");
        String userName = scan.nextLine();
        System.out.println("Informe a sua senha segura (necessario configurar o gmail) ");
        String password = scan.nextLine(); 
        System.out.println("Informe o email da pessoa que receberá o email");
        String toAddress = scan.nextLine(); 
        System.out.println("informe o assunto");
        String subject = scan.nextLine();; 
		
		
	       // Criação da sessão do email, com as propriedades, chave e valor
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", port);

	        
	        // cria sessão e valiada o email
	        Session session = Session.getInstance(props,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	          });

	        
	        
	        try {
	            // Criação do objeto MimeMessage para representar o email
	            Message message = new MimeMessage(session);  
	            message.setFrom(new InternetAddress(userName));
	            
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress)); 
	            message.setSubject(subject); 

	            // CRIAÇÃO DO CONTEUDO DO EMAIL
	            BodyPart messageBodyPart = new MimeBodyPart();   
	            String texto = "Olá,\n\nSegue a imagem em anexo.";
	            messageBodyPart.setText(texto);

	            Multipart multipart = new MimeMultipart(); 
	            multipart.addBodyPart(messageBodyPart);      

	          /*  
	           // ANEXANDO A IMAGEM
	            messageBodyPart = new MimeBodyPart();              
	            String fileName = "caminho/para/imagem.jpg";               
	           DataSource source = new FileDataSource(new File(fileName));  
	          messageBodyPart.setDataHandler(new DataHandler(source));       
	            messageBodyPart.setFileName("imagem.jpg"); 
	            multipart.addBodyPart(messageBodyPart);   
	 */
	            message.setContent(multipart);             
	            Transport.send(message);   
	            System.out.println("Email enviado com sucesso!");
	            return "texto ";
	        } catch (MessagingException e) {
	        	e.printStackTrace();
	            return "erro";
	        }
	       
		
		
		
		
		
		
	}
	
	
	
	
	
}
