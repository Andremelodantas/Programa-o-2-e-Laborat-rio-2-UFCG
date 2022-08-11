package Hashset;

import java.util.ArrayList;

public class alunos {
	private ArrayList listaAlunos = new ArrayList();

	public String matriculaAluno(String matricula) {
		listaAlunos.add(matricula);
		return "Aluno matriculado com sucesso!";
    }
    
}
