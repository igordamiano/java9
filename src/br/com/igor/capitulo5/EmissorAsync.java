package br.com.igor.capitulo5;

import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

public class EmissorAsync {

	public static void main(String[] args) {
		SubmissionPublisher<NF> publisher = new SubmissionPublisher<NF>();
		publisher.consume(WSPrefeitura::emit);

		// venda concluída
		String thread = Thread.currentThread().getName();
		System.out.println("thread principal: " + thread);
		
		System.out.println("Gerando a nota");
		NF nf = new NF("Turini", "Livro Java 9", 39.99);
		publisher.submit(nf);
		
		
			
		
		
		System.out.println("*** Parabéns pela sua compra ***");
		/*
		 saída provavelmente não será exibida(emitido!). Isso acontece porque a execução da aplicação
		termina antes que a thread secundária, de emissão de notas fiscais, seja executada. 
		Para resolver você pode travar a execução com um Scanner, por exemplo, pedindo para que o usuário digite algum valor
		quando quiser terminar a aplicação.
		 */
		System.out.println("Aperte o enter para sair");
		new Scanner(System.in).nextLine();

	}

}
