package Hashset;

import java.util.HashSet;

public class BomUso {
	private HashSet<Aluno> conjuntoAlunos = new HashSet<>();
	
	public void addAluno(Object aluno) {
		conjuntoAlunos.add(aluno);
	}
	
	public String verificaAluno(Object Aluno) {
		if(conjuntoAlunos.contains(Aluno)) {
			return "Cont�m Aluno";
		}
		return "Aluno n�o existe";
	}
}
