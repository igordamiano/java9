package br.com.igor.capitulo1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Datas {

	public static void main(String[] args) {

		// Criar datas nas versões antigas
		// Dia de ontem
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		
		// Com o Java 8 isso passou a ser feito assim, de forma fluente e
		// em um modelo imutável do pacote java.time
		LocalDateTime ontem = LocalDateTime.now().minusDays(1);
		
		//Você também consegue descobrir o intervalo entre uma data e outra de uma 
		//forma bem simples, utilizando o enum ChronoUnit dessa mesma API
		
		ChronoUnit.DAYS.between(ontem, LocalDate.now());
		
		
	}

}
