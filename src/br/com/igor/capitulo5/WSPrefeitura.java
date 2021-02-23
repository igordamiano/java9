package br.com.igor.capitulo5;

public class WSPrefeitura {

	/*
	 	Toda nota precisa ser enviada para a prefeitura de nossa
		cidade. Para simular esse processo, podemos criar uma classe que
		simule um web service que faz a integração, inclusive com uma
		demora de 5 segundos, para nos aproximar de um exemplo de
		execução real.
	 */
	
	public static void emit(NF nf) {
		try {
			String thread = Thread.currentThread().getName();
			System.out.println("emitindo na thread " + thread);
			Thread.sleep(5000);
			System.out.println("emitido!");
		} catch (Exception e) {
			System.out.println("falha ao emitir a nf");
		}
	}

}
