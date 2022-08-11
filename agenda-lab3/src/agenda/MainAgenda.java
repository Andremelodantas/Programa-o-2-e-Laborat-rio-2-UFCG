package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author André Melo
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(S)air\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n"+
						"(T)ags\n"+
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		case "F":
			favoritos(agenda);
			break;
		case "A":
			adicionarFavoritos(agenda,scanner);
			break;
		case "T":
			tags(agenda);
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		String[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(agenda.toString(i));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda, se o contato ainda não tiver sido cadastrado, mostra nada
	 * e se for uma posição acima ou abaixo do limite, retorna invalido.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		if (posicao>100 || posicao<1) {
			System.out.print("Posição invalida.\n");
		}else {
			String contato = agenda.getContato(posicao);
			System.out.println("Dados do contato:\n" + contato);
		}
		
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda,Scanner scanner) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		if (posicao>100 || posicao<1) {
			System.out.printf("POSIÇÃO INVALIDA\n");
		}else {
			System.out.print("\nNome> ");
			String nome = sc.nextLine().trim();
			System.out.print("\nSobrenome> ");
			String sobrenome = sc.nextLine().trim();
			System.out.print("\nTelefone> ");
			String telefone = sc.nextLine().trim();
			if (nome.length() == 0 || telefone.length() == 0) {
				System.out.println("CONTATO INVALIDO");
			}else {
				System.out.println(agenda.cadastraContato((posicao), nome, sobrenome, telefone));
			}
			
		}
		
		
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
	/**
	 * Lista os contatos em favoritos na suas devidas posições
	 * @param agenda A agenda
	 */
	public static void favoritos(Agenda agenda) {
		String[] favoritos = agenda.getFavoritos();
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				System.out.println(agenda.listarFavoritos(i));
			}
		}
	}
	/**
	 * Cadastra contato nos favoritos
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	public static void adicionarFavoritos(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicaoContato = scanner.nextInt();
		System.out.print("\nPosicao> ");
		int posicaoFavorito = scanner.nextInt();
		if (posicaoFavorito>10 || posicaoFavorito<1) {
			System.out.println("Posicao invalida.\n");
		}else {
			System.out.println(agenda.cadastraFavoritos(posicaoContato, (posicaoFavorito)));
		}
		
		
	}
	/**
	 * Método para adicionar tags aos contatos.
	 * @param agenda a agenda
	 */
	public static void tags(Agenda agenda) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Contato(s)>");
		String posicoes = sc.nextLine().trim();
		System.out.println("Tag> ");
		String tag = sc.next().trim();
		System.out.println("Posicao tag> ");
		int posicaoTag = sc.nextInt();
		if(posicaoTag<1 || posicaoTag>5) {
			System.out.println("Posição da tag invalida, só é permitido entre 1 e 5.");
		}else {
			System.out.println(agenda.adicionaTags(posicoes, tag, (posicaoTag)));
		}
		
	}


}
