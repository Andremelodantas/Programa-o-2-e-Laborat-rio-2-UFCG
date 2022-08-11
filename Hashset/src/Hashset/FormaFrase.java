package Hashset;

import java.util.HashSet;

public class FormaFrase {
	private HashSet<String>Frase = new HashSet<>();
	
	public String adicionaPalavra(String novaPalavra){
		Frase.add(novaPalavra);
		return "Palavra adiciona com sucesso.";
	}
	
		
}
