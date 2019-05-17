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
		weekDays.put(3, "Terça");
		weekDays.put(4, "Quarta");
		weekDays.put(5, "Quinta");
		weekDays.put(6, "Sexta");
		weekDays.put(7, "Sábado");
		weekDays = Collections.unmodifiableMap(weekDays);
		
		// da forma nova, com Map#of é imutável
		Map<Integer, String> weekDays1 = Map.of(
				1, "Domingo", 
				2, "Segunda", 
				3, "Terça", 
				4, "Quarta", 
				5, "Quinta", 
				6, "Sexta", 
				7, "Sábado");
		
		// da forma nova, com Map#ofEntries
		Map.ofEntries(
				Map.entry(1, "Domingo"), 
				Map.entry(2, "Segunda"), 
				Map.entry(3, "Terça") 
				);
		
		// listas da forma nova *** Coleções criadas a partir desses métodos são imutáveis
		List<String> names = List.of("Igor", "Eliana", "Letícia");
		try {
			names.add("Jorge"); // Vai dar erro, a lista é imutável
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		// sets da forma nova *** Coleções criadas a partir desses métodos são imutáveis
		// Ao usar o Set#of , por exemplo, não temos garantia de que será criada uma instância do 
		// tipo HashSet , TreeSet ou qualquer outro
		Set<String> colors = Set.of("Azul", "Branco", "Preto");
		
		// ArrayList.of("a", "b", "c"); // não compila
		
		// Você também não pode passar valores nulos para esses	métodos, pois isso 
		// resultará em uma NullPointerException
		
		try {
			List.of("não", "pode", "ter", null);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		// inserir chaves duplicadas em mapas e conjuntos causará um IllegalArgumentException
		try {
			Map.of(1, "a", 1, "b");
		} catch (Exception e) {
			// nao pode ter chaves duplicadas
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
