package br.com.igor.capitulo3;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsExercicios {

	public static void main(String[] args) {

		// forma antiga
		Map<Integer, String> weekDays = new HashMap<>();
		weekDays.put(1, "Domingo");
		weekDays.put(2, "Segunda");
		weekDays.put(3, "Ter�a");
		weekDays.put(4, "Quarta");
		weekDays.put(5, "Quinta");
		weekDays.put(6, "Sexta");
		weekDays.put(7, "S�bado");
		weekDays = Collections.unmodifiableMap(weekDays);
		
		// da forma nova, com Map#of � imut�vel
		Map<Integer, String> weekDays1 = Map.of(
				1, "Domingo", 
				2, "Segunda", 
				3, "Ter�a", 
				4, "Quarta", 
				5, "Quinta", 
				6, "Sexta", 
				7, "S�bado");
		
		// da forma nova, com Map#ofEntries
		Map.ofEntries(
				Map.entry(1, "Domingo"), 
				Map.entry(2, "Segunda"), 
				Map.entry(3, "Ter�a") 
				);
		
		// listas da forma nova *** Cole��es criadas a partir desses m�todos s�o imut�veis
		List<String> names = List.of("Igor", "Eliana", "Let�cia");
		try {
			names.add("Jorge"); // Vai dar erro, a lista � imut�vel
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		// sets da forma nova *** Cole��es criadas a partir desses m�todos s�o imut�veis
		// Ao usar o Set#of , por exemplo, n�o temos garantia de que ser� criada uma inst�ncia do 
		// tipo HashSet , TreeSet ou qualquer outro
		Set<String> colors = Set.of("Azul", "Branco", "Preto");
		
		// ArrayList.of("a", "b", "c"); // n�o compila
		
		// Voc� tamb�m n�o pode passar valores nulos para esses	m�todos, pois isso 
		// resultar� em uma NullPointerException
		
		try {
			List.of("n�o", "pode", "ter", null);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		// inserir chaves duplicadas em mapas e conjuntos causar� um IllegalArgumentException
		try {
			Map.of(1, "a", 1, "b");
		} catch (Exception e) {
			// nao pode ter chaves duplicadas
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
