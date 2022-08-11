package BEPP;

import agenda.Contato;

public class ControleBordado {
	private int numeroBordado;
	private int linhasBordado;
	private int colunasBordado;
	private Bordados[] Bordados = new Bordados[10];
	
	public ControleBordado(int bordado, int linha, int coluna) {
		this.numeroBordado=bordado;
		this.linhasBordado=linha;
		this.colunasBordado=coluna;
		
	}
	
	public void Cadastro() {
		this.Bordados[numeroBordado] = new Bordados(linhasBordado,colunasBordado);
	}
}
