package br.com.igor.capitulo5;

import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

public class EmissorAsync {

	public static void main(String[] args) {
		SubmissionPublisher<NF> publisher = new SubmissionPublisher<NF>();
		publisher.consume(WSPrefeitura::emit);

		// venda conclu�da
		String thread = Thread.currentThread().getName();
		System.out.println("thread principal: " + thread);
		
		System.out.println("Gerando a nota");
		NF nf = new NF("Turini", "Livro Java 9", 39.99);
		publisher.submit(nf);
		
		
			
		
		
		System.out.println("*** Parab�ns pela sua compra ***");
		/*
		 sa�da provavelmente n�o ser� exibida(emitido!). Isso acontece porque a execu��o da aplica��o
		termina antes que a thread secund�ria, de emiss�o de notas fiscais, seja executada. 
		Para resolver voc� pode travar a execu��o com um Scanner, por exemplo, pedindo para que o usu�rio digite algum valor
		quando quiser terminar a aplica��o.
		 */
		System.out.println("Aperte o enter para sair");
		new Scanner(System.in).nextLine();

	}

}
