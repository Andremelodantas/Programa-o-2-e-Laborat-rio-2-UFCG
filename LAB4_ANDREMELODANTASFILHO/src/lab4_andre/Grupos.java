package lab4_andre;

import java.util.ArrayList;
//import java.util.Objects;

/**
 * Classe para armazenar dados de cada grupo, um arrayList com o tamanho solicitado quando criado, 
 * com a matricula de cada aluno participante
 * Qualquer parametro invalido passado para os metodos da classes resultaram em um erro.
 * @author André
 *
 */
public class Grupos {

	private ArrayList<String> alunosGrupo = new ArrayList();
	private String nomeGrupo;
	private int vagasGrupo;
	/**
	 * Construtor do grupo, criando um arrayList com o tamanho solicitado e dando nome pro grupo
	 * @param nomeGrupo nome do grupo em String
	 * @param  delimitação do grupo.
	 */
	public Grupos(String nomeGrupo, int tamanho) {
		if(nomeGrupo == null | nomeGrupo.isEmpty()) {
			throw new NullPointerException("Grupo invalido!");
		}else if(tamanho<=0) {
			throw new IllegalArgumentException("Tamanho invalido!");
		}
		this.nomeGrupo = nomeGrupo;
		this.vagasGrupo = tamanho;
	}
	/**
	 * Construtor do Grupo quando o usuario não solicita o tamanho, criando um arrayList.
	 * @param nomeGrupo nome do grupo em String
	 */
	public Grupos(String nomeGrupo) {
		if(nomeGrupo == null | nomeGrupo.isEmpty()) {
			throw new NullPointerException("Grupo invalido!");
		}
		this.nomeGrupo = nomeGrupo;
		this.vagasGrupo = Integer.MAX_VALUE;
	}
	/**
	 * Método para obter as vagas restantes do grupo para evitar ultrapassar do limite.
	 * @return número de vagas em inteiro.
	 */
	public int getVagas() {
		return this.vagasGrupo;
	}
	/**
	 * Método para adicionar aluno no grupo através da sua matricula.
	 * @param matricula matricula do aluno para ser adicionado no array em String
	 */
	public String adicionaGrupo(String matricula) {
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matr�cula invalida!");
		}else {
			for (int i = 0;i<this.alunosGrupo.size();i++) {
				if(this.alunosGrupo.get(i) == null) {
					
				}
				
				if(this.alunosGrupo.get(i).equals(matricula)) {
					return "Aluno j� foi alocado com sucesso para o grupo , n�o ser� alocado novamente.";
				}
			}
		}
		this.alunosGrupo.add(matricula);
		this.vagasGrupo= this.vagasGrupo-1;
		return "ALUNO ALOCADO!";
	}
	/**
	 * Método para verificar se o aluno est� no grupo percorrendo o arrayList todo em busca.
	 * @param matricula matricula a ser buscada no arrayList.
	 * @return retorna se o aluno esta ou não no grupo em String
	 */
	
	public String verificaAluno(String matricula) {
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matrícula invalida!");
		}
		for (int i = 0;i<this.alunosGrupo.size();i++) {
			if(this.alunosGrupo.get(i) == null) {
				
			}else if(this.alunosGrupo.get(i).contains(matricula)) {
				return "ALUNO PERTENCE AO GRUPO";
			}
		}
		return "ALUNO NÃO PERTENCE AO GRUPO";
	}
	

}
