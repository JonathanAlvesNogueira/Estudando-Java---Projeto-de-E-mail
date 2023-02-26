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
			opc = scan.nextInt();
			switch(opc) {
			
			// envia email sem nada
			case 1:
				c.enviarEmail();
				break;
			// grava o email que foi enviado
			case 2: 
				String qualSeuNome = scan.nextLine();
				String nome = nomes.contains(qualSeuNome) ? qualSeuNome : "Não tem";
				if(nome.equals("Não tem")) {
					System.err.println("Esse nome não esta na lista");
				}else {
					emails.putAll(c.gravarEmailMandado(qualSeuNome));
					break;
				}
				
				
			// cadastra o cliente
			case 3:
				System.out.println("Escreva seu nome completo");
				String cadastro = scan.nextLine();
				nomes.add(cadastro);
				break;
				
			// verifica cliente	
			case 4: 
				System.out.println("Digite seu nome inteiro para verificar se ja é um usuario");
				String verificaNome = scan.nextLine();
				if(emails.containsValue(verificaNome)) {
					System.out.println(emails.get(verificaNome));
				}else {
					System.out.println("Não tem");
				}
				break;
			// verifica e devolve o email gravado
			case 5:
				System.out.println("Coloque seu nome para verificar o email gravado");
				String seuNome = scan.nextLine();
				if(emails.containsValue(seuNome)) {
					System.out.println("Esse foi o email enviado por você:     " + emails.get(seuNome));
				}else {
					System.out.println("Você nã gravou seu email");
				}
				
				
				
			}
		}
		System.out.println("Processo finalizado!");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
