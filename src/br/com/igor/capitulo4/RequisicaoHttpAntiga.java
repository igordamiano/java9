package br.com.igor.capitulo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class RequisicaoHttpAntiga {

	public static void main(String[] args) throws IOException {

		
		URL url = new URL("https://www.casadocodigo.com.br/");
		
		URLConnection urlConnection = url.openConnection();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String linha;
		while((linha = reader.readLine()) != null ) {
			System.out.println(linha);
		}
		reader.close();
		
	}

}
