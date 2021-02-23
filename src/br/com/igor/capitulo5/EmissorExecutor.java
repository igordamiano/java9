package br.com.igor.capitulo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

public class EmissorExecutor {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		SubmissionPublisher<NF> publisher = new SubmissionPublisher<NF>(executorService, 1);
		
		publisher.consume(WSPrefeitura::emit);
		
		publisher.consume(data -> {
			System.out.println("A outra thread é: " + Thread.currentThread().getName());
		});
		
		NF nf = new NF("Turini", "Livro Java 9", 39.99);
		publisher.submit(nf);
		
	}

}
