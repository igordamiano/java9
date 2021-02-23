package br.com.igor.capitulo5;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

public class NFFilterProcessor extends SubmissionPublisher<NF> implements Flow.Processor<NF, NF> {

	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(NF nf) {
		if (nf.hasValidAmount()) {
			submit(nf);
		} else {
			System.out.println("Nota com valor menor ou igual a zero");
		}
		subscription.request(1);

	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onComplete() {
		close();

	}

}
