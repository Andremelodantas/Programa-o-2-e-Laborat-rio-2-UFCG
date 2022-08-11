package BEPP;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		menu();
		Scanner sc = new Scanner(System.in);
		String acao = sc.next();
		switch(acao) {
		case "A":
			cadastrarbordado;
			break;
		case "B":
			atualizarbordado;
			break;
		case "C":
			imprimir bordado;
			break;
		case "D":
			Listar bordado;
			break;
		case "E":
			cadastrar quadro;
			break;
		case "F":
			att quadro;
			break;
		case "G":
			exibir quadro;
			break;
		default:
			//print ERRO!
		}
		
		

	}
	
	public static void menu() {
		//print boas vindas e menu
	}

	public static void cadastrabordado() {
		Numero do bordado? [0-9] 0

		Numero de linhas? [2-100] 10

		Numero de colunas [2-100] 5
		classe cadastra
		chama cadastro
	}
}
