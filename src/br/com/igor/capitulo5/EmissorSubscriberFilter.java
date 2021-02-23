package br.com.igor.capitulo5;

import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

public class EmissorSubscriberFilter {

	public static void main(String[] args) {
		
		SubmissionPublisher<NF> publisher = new SubmissionPublisher<NF>();
		
		NFSubscriber subscriber = new NFSubscriber();
		NFFilterProcessor filter = new NFFilterProcessor();
		publisher.subscribe(filter);
		filter.subscribe(subscriber);
		
		// Venda concluída
		String thread = Thread.currentThread().getName();
		
		System.out.println("thread principal: " + thread);
		System.out.println("Gerando nota fiscal");
		
		NF nf = new NF("Turini", "Livro Java 9", 39.99);
		publisher.submit(nf);
		
		NF nf2 = new NF("Turini", "Livro Java 9", 0);
		publisher.submit(nf2);
		
		System.out.println("Parabéns pela sua compra");
		publisher.close();
		System.out.println("Aperte o enter para sair");
		new Scanner(System.in).nextLine();

	}

}
