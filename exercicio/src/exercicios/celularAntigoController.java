package exercicios;

public class celularAntigoController {
	
	private Calculadora calculadora = new Calculadora();
	public int usarCalculadora(String operacao, int num1, int num2) {
		return calculadora.executar(operacao,num1,num2);
	}

}
