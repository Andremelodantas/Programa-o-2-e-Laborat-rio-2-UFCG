package lab4_andre;
import java.util.Scanner;
//import java.util.HashMap;

/**
 * Interface de interação com usuario para um controle de alunos
 * @author André
 *
 */
public class main {

	public static void main(String[] args) {
		ControleAlunos controleAlunos = new ControleAlunos();
		String escolha = "";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			escolha = menu(scanner);
			comando(escolha,scanner,controleAlunos);
		}

	}
	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	public static String menu(Scanner scanner) {
		System.out.println("\n(C)adastrar Aluno\n"
				+ "(E)xibir Aluno\n"
				+ "(N)ovo Grupo\n"
				+ "(A)locar Aluno no Grupo e Verificar pertin�ncia a Grupos\n"
				+ "(R)egistrar Aluno que Respondeu\n"
				+ "(I)mprimir Alunos que Responderam\n"
				+ "(O)lhaí quais Grupos o Aluno Tá.\n"
				+ "(S)im, quero Fechar o Programa!\n"
				+ "\n"
				+ "Opção> ");
		return scanner.next().toUpperCase();
		
	}
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao Opção digitada.
	 * @param controleAlunos  O controle de alunos que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	public static void comando(String escolha, Scanner scanner, ControleAlunos controleAlunos) {
		if(escolha.equals("C")) {
			cadastrarAluno(scanner,controleAlunos);
		}else if(escolha.equals("E")) {
			exibirAluno(scanner,controleAlunos);
		}else if(escolha.equals("N")) {
			novoGrupo(scanner,controleAlunos);
		}else if(escolha.equals("A")) {
			alocarAluno(scanner,controleAlunos);
		}else if(escolha.equals("R")) {
			registrarAlunoRespondeu(scanner, controleAlunos);
		}else if(escolha.equals("I")) {
			imprimeAlunoRespostas(controleAlunos);
		}else if(escolha.equals("O")) {
			verificaGrupos(scanner, controleAlunos);
		}else if(escolha.equals("S")) {
			sai();
		}else if(escolha.length()==0 || escolha.isEmpty()) {
			throw new NullPointerException("Op��o invalida!");
		}else {
			System.out.println("Op��o invalida!\n");
		}
	}
	
	
	/**
	 * Método para acessar todos os grupos que o aluno faz parte, enviando sua matricula para 
	 * o objeto ControleAlunos e deixando para ele retornar os grupos.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 * @param controleAlunos O controle de alunos que estamos manipulando.
	 */
	private static void verificaGrupos(Scanner scanner, ControleAlunos controleAlunos) {
		System.out.printf("Matrícula: ");
		String matricula = scanner.next();
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matrícula invalida!");
		}
		System.out.printf("GRUPOS:\n%s",controleAlunos.olhaGrupos(matricula));
		
	}
	/**
	 * Método para imprimir todos os alunos que responderam perguntas.
	 * @param controleAlunos O controle de alunos que estamos manipulando.
	 */
	private static void imprimeAlunoRespostas(ControleAlunos controleAlunos) {
		System.out.println(controleAlunos.imprimeRespostas());
	}
	/**
	 * M�todo para registrar o aluno que respondeu a pergunta do professor, enviando sua matricula para o objeto ControleAlunos.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 * @param controleAlunos O controle de alunos que estamos manipulando.
	 */
	private static void registrarAlunoRespondeu(Scanner scanner, ControleAlunos controleAlunos) {
		System.out.printf("Matrícula: ");
		String matricula = scanner.next();
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matrícula invalida!");
		}
		System.out.println(controleAlunos.registraResposta(matricula));
		
	}
	/**
	 * Método para alocar ou verificar pertinencia de um aluno no grupo, fazendo assim
	 * uma interação com o usuario para saber qual operação fazer.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 * @param controleAlunos O controle de alunos que estamos manipulando.
	 */
	private static void alocarAluno(Scanner scanner, ControleAlunos controleAlunos) {
		System.out.printf("(A)locar Aluno ou (P)ertinência a Grupo?");
		String opcao = scanner.next().toUpperCase();
		if (opcao.equals("A")) {
			System.out.printf("Matrícula: ");
			String matricula = scanner.next();
			System.out.printf("Grupo: ");
			String grupo = scanner.next().toLowerCase().trim();
			if(matricula == null | matricula.isEmpty()) {
				throw new NullPointerException("Matrícula invalida!");
			}else if(grupo == null | grupo.isEmpty()) {
				throw new NullPointerException("Grupo invalido!");
			}
			System.out.println(controleAlunos.alocarAluno(matricula,grupo));
		}else if(opcao.equals("P")) {
			System.out.printf("Grupo: ");
			String grupo = scanner.next().toLowerCase().trim();
			System.out.printf("Aluno: ");
			String aluno = scanner.next();
			if(grupo == null | grupo.isEmpty()) {
				throw new NullPointerException("Grupo invalido!");
			}
			else if(aluno == null | aluno.isEmpty()) {
				throw new NullPointerException("Aluno invalido!");
			}
			System.out.println(controleAlunos.pertinenciaGrupo(grupo,aluno));
		}else {
			System.out.println("Opção invalida.");
		}
		
	}
	/**
	 * Método para criar novo grupo no objeto ControleAlunos, passando seu nome e o tamanho do grupo.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 * @param controleAlunos O controle de alunos que estamos manipulando.
	 */
	private static void novoGrupo(Scanner scanner, ControleAlunos controleAlunos) {
		System.out.printf("Grupo: ");
		scanner.nextLine();
		String grupo = scanner.nextLine().toLowerCase().trim();
		if(grupo == null | grupo.isEmpty()) {
			throw new NullPointerException("Grupo invalido!");
		}
		System.out.printf("Tamanho: ");
		
		String tamanho=scanner.nextLine();
		
		System.out.println(controleAlunos.novoGrupo(grupo,tamanho));
	}
	/**
	 * Método para acessar os dados de um aluno no objeto ControleAlunos.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 * @param controleAlunos O controle de alunos que estamos manipulando.
	 */
	private static void exibirAluno(Scanner scanner, ControleAlunos controleAlunos) {
		System.out.printf("Matrícula> ");
		String matricula = scanner.next();
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matrícula invalida!");
		}
		System.out.println(controleAlunos.consultaAluno(matricula));
		
	}
	/**
	 * Método para encerrar o programa quando o usuario solicitar.
	 */
	public static void sai() {
		System.out.println("\nPrograma encerrado.");
		System.exit(0);
	}
	/**
	 * Método para cadastrar aluno no sistema, enviando matricula, nome e curso,
	 * caso as Strings que serão passadas como parametros forem invalidas,
	 * apresentado um erro.
	 * @param controleAlunos  O controle de alunos que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	public static void cadastrarAluno(Scanner scanner, ControleAlunos controleAlunos) {
		System.out.printf("Matrícula> ");
		String matricula = scanner.next();
		System.out.printf("Nome> ");
		scanner.nextLine();
		String nome = scanner.nextLine();
		System.out.printf("Curso> ");
		String curso = scanner.nextLine();
		if(matricula == null | matricula.isEmpty()) {
			throw new NullPointerException("Matrícula invalida!");
		}else if(nome == null | nome.isEmpty()) {
			throw new NullPointerException("Nome invalido!");
		}else if(curso == null | curso.isEmpty()) {
			throw new NullPointerException("Curso invalido!");
		}
		System.out.println(controleAlunos.cadastro(matricula, nome, curso));
	}

}

