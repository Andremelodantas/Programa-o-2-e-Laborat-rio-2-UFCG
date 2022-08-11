package lab4_andre;


import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashSet;

/**
 * Classe principal de controle dos alunos, grupos e alunos que responderam a perguntas no quadro,
 * tudo isso atraves de estrutura de dados como HashMap e ArrayList.
 * Qualquer parametro invalido passado para os metodos da classes resultaram em um erro.
 * @author André
 *
 */
public class ControleAlunos {
	private HashMap<String, Alunos> mapaMatriculaAlunos = new HashMap<>();
	private HashMap<String,Grupos> grupos = new HashMap<>();
	private ArrayList<String> respostasAluno = new ArrayList<String>();
	/**
	 * Método para cadastrar o alunos, através das suas informações, enviando para um objeto especifico para organizar tudo isso
	 * e ligando a matricula do aluno a seu objeto através de um Hashmap, não permitindo duplicidade de alunos.
	 * @param matricula matricula do aluno em String
	 * @param nome nome do aluno em String
	 * @param curso curso que o aluno pertence em String
	 * @return retorna se o aluno foi cadastro com sucesso ou se houve erro de duplicidade.
	 */
	public String cadastro(String matricula, String nome, String curso) {
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matr�cula invalida!");
		}else if(nome == null | nome.isEmpty()) {
			throw new NullPointerException("Nome invalido!");
		}else if(curso == null | curso.isEmpty()) {
			throw new NullPointerException("Curso invalido!");
		}
		else if (this.mapaMatriculaAlunos.containsKey(matricula)) {
			return "MATR�CULA J� CADASTRADA!\n";
		}
		Alunos Alunos = new Alunos(matricula, nome, curso);
		this.mapaMatriculaAlunos.put(matricula, Alunos);
		return "CADASTRO REALIZADO!\n";
	}
	/**
	 * Método para retornar informações do aluno solicitado em String acessando o objeto do aluno.
	 * @param matricula matricula para acessar o HashMap do aluno e encontrar seu objeto.
	 * @return retorna informações do aluno ou se não houver aluno, informa isso.
	 */
	public String consultaAluno(String matricula) {
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matrícula invalida!");
		}
		else if(this.mapaMatriculaAlunos.containsKey(matricula)) {
			return this.mapaMatriculaAlunos.get(matricula).toString();
		}
		return "Aluno não cadastrado.";

	}
	/**
	 * Método para criar um novo grupo, associando seu nome ao seu objeto no HashMap dos grupos.
	 * @param nomeGrupo nome do grupo para enviar para o objeto e ser a chave do HashMap.
	 * @param tamanho tamanho do grupo para delimitar as vagas.
	 * @return retorna sucesso no cadastro do grupo ou se já houver o grupo, informa isso.
	 */
	public String novoGrupo(String nomeGrupo,String tamanho){
		if(nomeGrupo == null | nomeGrupo.isEmpty()) {
			throw new NullPointerException("Grupo invalido!");
		}
		else if (this.grupos.containsKey(nomeGrupo)) {
			return "GRUPO JÁ CADASTRADO!";
		}else if(tamanho.isBlank()) {
			Grupos Grupos = new Grupos(nomeGrupo);
			this.grupos.put(nomeGrupo,Grupos);
		}
		else {
			Grupos Grupos = new Grupos(nomeGrupo,Integer.parseInt(tamanho));
			this.grupos.put(nomeGrupo,Grupos);
		}
		return "GRUPO CADASTRADO COM SUCESSO!";
	}
	/**
	 * Método para alocar aluno para o grupo, enviando a matricula do aluno ao objeto do respectivo grupo e tamb�m adicionando
	 * o grupo na lista de grupos que o aluno participa dentro do objeto Aluno.
	 * @param matricula matricula do aluno para enviar para ser adicionado.
	 * @param grupo nome do grupo para achar a chave do HashMap e seu objeto.
	 * @return 4 possibilidades de retorno, se não houver o aluno ou grupo informar isso, ou se o grupo tiver cheio e tamb�m o sucesso no alocamento.
	 */
	public String alocarAluno(String matricula, String grupo) {
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matrícula invalida!");
		}else if(grupo == null | grupo.isEmpty()) {
			throw new NullPointerException("Grupo invalido!");
		}
		else if(this.mapaMatriculaAlunos.containsKey(matricula)==false) {
			return "Aluno não cadastrado.";
		}else if(this.grupos.containsKey(grupo)==false) {
			return "Grupo não cadastrado.";
		}
		else if(this.grupos.get(grupo).getVagas()<=0) {
			return "GRUPO CHEIO.";
		}else {
			System.out.println(grupos.get(grupo).adicionaGrupo(matricula));
			this.mapaMatriculaAlunos.get(matricula).adicionaGrupo(grupo);
		}
		return "ALUNO ALOCADO!";
	}
	/**
	 * Método para verificar se o aluno pertence ao grupo ou não.
	 * @param grupo chave do HashMap para indentificar o objeto do grupo.
	 * @param aluno matricula do aluno para procurar no respectivo grupo.
	 * @return se não houver grupo, informa isso, se achar o aluno no grupo, retorna que o aluno pertence ao grupo.
	 */
	public String pertinenciaGrupo(String grupo, String aluno) {
		if(grupo == null | grupo.isEmpty()) {
			throw new NullPointerException("Grupo invalido!");
		}
		else if(aluno == null | aluno.isEmpty()) {
			throw new NullPointerException("Aluno invalido!");
		}
		else if(this.grupos.containsKey(grupo)==false) {
			return "GRUPO NÃO CADASTRADO.";
		}else if(this.mapaMatriculaAlunos.containsKey(aluno)==false) {
			return "ALUNO NãO CADASTRADO.";
		}
		return this.grupos.get(grupo).verificaAluno(aluno);
	
	}
	/**
	 * Metodo para registrar o aluno que respondeu a pergunta no quadro, adicionando sua matricula no ArrayList responsavel.
	 * @param matricula para adicionar a lista.
	 * @return se não houver o aluno, retorna isso, ou o sucesso do registro do aluno.
	 */
	public String registraResposta(String matricula) {
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matrícula invalida!");
		}
		else if(this.mapaMatriculaAlunos.containsKey(matricula)==false) {
			return "Aluno não cadastrado.";
		}
		this.respostasAluno.add(matricula);
		return "ALUNO REGISTRADO!";
	}
	/**
	 * Método para obter todos os alunos que responderam as perguntas no quadro para respectiva ordem.
	 * @return String com a lista dos alunos que responderam.
	 */
	public String imprimeRespostas() {
		String retorno= "";
		for (int i=0; i<this.respostasAluno.size(); i++) {
		      retorno += i+1+ ". " + this.mapaMatriculaAlunos.get(this.respostasAluno.get(i).toString()) + "\n";
		    }
		return retorno;
	}
	/**
	 * Método para obter todos os grupos que o aluno pertence, acessando o objeto aluno e solicitando isso.
	 * @param matricula para chave do HashMap e encontrar objeto do aluno.
	 * @return grupos que o aluno pertence.
	 */
	public String olhaGrupos(String matricula) {
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matrícula invalida!");
		}
		return this.mapaMatriculaAlunos.get(matricula).listaGrupos();
	}

	

}
