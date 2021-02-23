package br.com.igor.capitulo5;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class NFSubscriber implements Subscriber<NF>{

	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1); // assinante está pronto pra receber 1 novo item
		
	}

	@Override
	public void onNext(NF nf) {
		WSPrefeitura.emit(nf);
		/*
		 Novamente estamos usando a subscription.request(1) para informar ao publicador que, nesse ponto, depois de executar o
			web service, estamos preparados para receber mais um elemento. Ele faz o trabalho e pede mais um.
			Publicador envia, ele faz o trabalho e pede mais um.
		 */
		subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Todas as notas foram emitidas");
		
	}

}
