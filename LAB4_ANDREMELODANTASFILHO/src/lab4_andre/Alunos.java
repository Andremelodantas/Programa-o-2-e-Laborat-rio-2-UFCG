package lab4_andre;

import java.util.ArrayList;
/**
 * Classe para armazenar todos os dados de cada aluno, matricula, curso, nome e grupos pertencentes.
 * Qualquer parametro invalido passado para os metodos da classes resultaram em um erro.
 * @author André
 *
 */
public class Alunos {
	
	private String matricula;
	private String nome;
	private String curso;
	private ArrayList<String> gruposPertence = new ArrayList<String>();
	/**
	 * Construtor para armazenar matricula, nome e curso do aluno, passado pelo ControleAlunos.
	 * @param matricula número da matricula em String
	 * @param nome nome do aluno em String
	 * @param curso curso do aluno em String
	 */
	public Alunos(String matricula, String nome, String curso) {
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matrícula invalida!");
		}else if(nome == null | nome.isEmpty()) {
			throw new NullPointerException("Nome invalido!");
		}else if(curso == null | curso.isEmpty()) {
			throw new NullPointerException("Curso invalido!");
		}
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	/**
	 * Método para retornar o objeto em forma de String, com todas as principais informações do aluno.
	 */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	/**
	 * Método para adicionar à lista de grupos que o aluno pertence o novo grupo que ele entrou.
	 * @param nomeGrupo nome do grupo em String
	 */
	public void adicionaGrupo(String nomeGrupo) {
		if(nomeGrupo==null | nomeGrupo.isBlank()) {
			throw new NullPointerException("Nome do grupo invalido!");
		}
		this.gruposPertence.add(nomeGrupo);
	}
	/**
	 * Metodo para retornar todos os grupos que o aluno faz parte.
	 * @return lista de grupos que o aluno participa em String
	 */
	public String listaGrupos(){
		String retorno = "";
		for(int i=0;i<this.gruposPertence.size();i++) {
			retorno+= "- " + this.gruposPertence.get(i) +"\n";
		}
		return retorno.toUpperCase();
	}
	
}
