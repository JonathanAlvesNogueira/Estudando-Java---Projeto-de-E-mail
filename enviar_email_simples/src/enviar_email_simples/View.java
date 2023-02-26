package enviar_email_simples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {

	public static void main(String[] args) throws Exception {
		Controller c = new Controller();
		Scanner scan = new Scanner(System.in);
		List<String> nomes = new LinkedList<>();
		Map<String, String> emails = new HashMap<>();
		
		
		int opc = 0;
		while(opc != 9) {
			System.out.println("Informe a opção que deseja selecionar 1- Enviar apenas o email sem cadastro"
					+  " \n 2 - grava o email e envaia(precisa ter cadatro) "
					+ "\n 3 - Cadastra o cliente "
					+ " \n 4- verifica o cliente "
					+ "\n 5 - verifica e devolve o email gravado");
			opc = scan.nextInt();
			switch(opc) {
			
			// envia email sem nada
			case 1:
				c.enviarEmail();
				break;
			// grava o email que foi enviado
			case 2: 
				scan.nextLine();
				 System.out.println("Qual é o seu nome completo?");
				    String nome = scan.nextLine();
				    if (nomes.contains(nome)) {
				        String texto = c.gravarEmailMandado(nome);
				        emails.put(nome, texto);
				    } else {
				        System.err.println("Nome não encontrado na lista de clientes");
				    }
				    // adiciona essa linha para consumir o caractere de nova linha
				    scan.nextLine();
				    break;





				
				
			// cadastra o cliente
			case 3:
				scan.nextLine();
				System.out.println("Escreva seu nome completo");
				
				try {
					nomes.add(scan.nextLine());					
				}catch(Exception e) {
					System.out.println("Mandou mensagem errado " + e.getMessage());
				}
				
				
				
				break;
				
			// verifica cliente	
			case 4: 
				scan.nextLine();
				System.out.println("Digite seu nome inteiro para verificar se ja é um usuario");
				String verificaNome = scan.nextLine();
				if(emails.containsValue(verificaNome)) {
					System.out.println(emails.get(verificaNome));
				}else {
					System.out.println("Não tem");
				}
				scan.nextLine();
				break;
			// verifica e devolve o email gravado
			case 5:
				scan.nextLine();
				System.out.println("Coloque seu nome para verificar o email gravado");
				String seuNome = scan.nextLine();
				if(emails.containsValue(seuNome)) {
					System.out.println("Esse foi o email enviado por você:     " + emails.get(seuNome));
				}else {
					System.out.println("Você nã gravou seu email");
				}
				break;
				
				
				
			}
		}
		System.out.println("Processo finalizado!");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
