package br.com.igor.capitulo5;

public class EmissorSync {

	public static void main(String[] args) {

		System.out.println("Gerando a nota");
		NF nf = new NF("Turini", "Livro Java 9", 39.99);
		WSPrefeitura.emit(nf);
		// outras a��es necess�rias
		System.out.println("*** Parab�ns pela sua compra ***");

	}

}
