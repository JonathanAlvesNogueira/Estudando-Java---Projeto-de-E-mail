package enviar_email_simples;



public class Controller {


		public void enviarEmail(){
			// System.out.println("Você deseja mandar apenas por um email ?");
			
			
			String userName = "";
			String senha = "";
			String stmHost = "stmp.example.com";
			final int smtpPort = 587;
		      final String fromEmail = "seuemail@dominio.com";
		      final String toEmail = "destinatario@dominio.com";

		      // Configurações de propriedades do JavaMail
		      Properties props = new Properties();
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.host", smtpHost);
		      props.put("mail.smtp.port", smtpPort);

		      // Cria uma sessão de email com autenticação
		      Session session = Session.getInstance(props,
		         new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(username, password);
		            }
		         });

		      try {
		         // Cria um objeto MimeMessage para representar o email
		         Message message = new MimeMessage(session);
		         message.setFrom(new InternetAddress(fromEmail));
		         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
		         message.setSubject("Assunto do email");

		         // Corpo do email
		         String msg = "Olá,\n\nEste é um exemplo de email enviado usando JavaMail com autenticação SMTP.\n\nAtenciosamente,\nJavaMail";
		         message.setText(msg);

		         // Envia o email
		         Transport.send(message);

		         System.out.println("Email enviado com sucesso!");

		      } catch (MessagingException e) {
		         throw new RuntimeException(e);
		      }
		
			
			
			
			
			
			
			
		}
		
		
		
		
		

}
