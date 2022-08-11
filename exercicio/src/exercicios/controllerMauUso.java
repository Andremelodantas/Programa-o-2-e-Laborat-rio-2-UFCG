package exercicios;

public class controllerMauUso {
	public int usaCalculadora(String operacao,int num1,int num2) {
		if(operacao.equals("+"))return num1 + num2;
		else if(operacao.equals("-"))return num1 - num2;
		else if(operacao.equals("*")) return num1 * num2;
		else if(operacao.equals("/")) return num1 / num2;
		return 00;
	}
	
}
