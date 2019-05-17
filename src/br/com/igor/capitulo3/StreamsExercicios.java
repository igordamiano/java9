package br.com.igor.capitulo3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExercicios {

	public static void main(String[] args) {

		Map<Integer, String> weekDays = new HashMap<>();
		weekDays.put(1, "Domingo");
		weekDays.put(2, "Segunda");
		weekDays.put(3, "Ter�a");
		weekDays.put(4, "Quarta");
		weekDays.put(5, "Quinta");
		weekDays.put(6, "Sexta");
		weekDays.put(7, "S�bado");
		weekDays.put(8, null); // com essa linha daria NPE

		// iniciais de seus valores, ou seja, dos nomes dos dias da	semana. 
		List<String> dayNames = weekDays
				.entrySet()
				.stream()
				.flatMap(e -> Stream.ofNullable(e.getValue())) //agora est� protegido para n�o dar NullPointerException
				.map(s -> s.substring(0, 3))
				.collect(Collectors.toList());
		
		System.out.println(dayNames);
		
		// resolvendo com filter da forma antiga
		List<String> dayNames1 = weekDays
					.entrySet()
					.stream()
					.flatMap(e -> Stream.of(e.getValue()))
					.filter(s -> s != null)
					.map(s -> s.substring(0,3))
					.collect(Collectors.toList());
				
		// adicionar um limite em uma cole��o. Estes s�o os m�todos skip e limit		
		
		// Com o skip , por exemplo, eu posso escrever esse trecho de c�digo para pular os 5 primeiros 
		// valores desse Stream de inteiros e retornar apenas o restante:
		IntStream.range(0, 10).skip(5).forEach(System.out::println);
		System.out.println("-------------------------------------------------------");
		// J� o limit , seu outro m�todo, nos permite adicionar um limite m�ximo a essa sequ�ncia de inteiros
		IntStream.range(0, 10).limit(3).forEach(System.out::println);
		System.out.println("-------------------------------------------------------");
		
		// dropWhile - remover todos os n�meros que sejam menor ou igual a 5
		IntStream.range(0, 10).dropWhile(e -> e <= 5).forEach(System.out::println);
		
		System.out.println("-------------------------------------------------------");
		
		//� importante perceber que, assim que algum dos elementos retornar false , 
		// o dropWhile vai parar de remover, por isso imprimiu 3 2 1 que s�o menores que 5
		IntStream.of(3,5,6,7,3,2,1).dropWhile(e -> e <= 5).forEach(System.out::println);
		
		System.out.println("-------------------------------------------------------");
		// takeWhile - No lugar de remover, ele vai manter os n�meros enquanto a condi��o for verdadeira
		IntStream.range(0, 10).takeWhile(e -> e <= 5).forEach(System.out::println);
		
		System.out.println("-------------------------------------------------------");
		//remove todas as Strings que antecedem a palavra "no"
		
		Stream.of("muitas", "novidades", "no", "java")
			.dropWhile(s -> !s.equals("no"))
			.forEach(System.out::println);

		System.out.println("-------------------------------------------------------");
		//takeWhile - mant�m todas as strings at� chegar na palavra "no"
		Stream.of("muitas", "novidades", "no", "java")
			.takeWhile(s -> !s.equals("no"))
			.forEach(System.out::println);
		
		System.out.println("-------------------------------------------------------");
		// Criando loops com iterate
		
		// looping da forma antiga
		for (int i = 0; i <= 10; i = i + 1) {
			System.out.println(i);
		}
		System.out.println("-------------------------------------------------------");
		// com o iterate , far�amos o mesmo
		Stream.iterate(1, n -> n <=10, n -> n + 1)
			.forEach(System.out::println);
		
		System.out.println("-------------------------------------------------------");
		Stream.iterate(1, n -> n + 1)
			.limit(10)
			.forEach(System.out::println);
		
		// NOVOS COLLECTORS
		
		
		
		
		
		
		
		
		
	}

}
