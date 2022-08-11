package lab4_andre;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunosTest {
	private Alunos Alunos;
	@Test
	void toStringTest() {
		Alunos = new Alunos("200", "cleiton", "medicina");
		assertEquals("200 - cleiton - medicina",Alunos.toString(),"200 - cleiton - medicina");
	}
	
	@Test
	void listaGruposTest() {
		Alunos Alunos = new Alunos("200", "cleiton", "medicina");
		Alunos.adicionaGrupo("amigos");
		Alunos.adicionaGrupo("estudos");
		assertEquals("- AMIGOS\n- ESTUDOS\n",Alunos.listaGrupos(),"- AMIGOS\n- ESTUDOS\n");
	}
	
	//Testes de parametros invalidos e exceções na classe
	@Test
	void construtorMatriculaInvalidaTest() {
		try {
			Alunos = new Alunos(null,"andré","computação");
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void construtorNomeInvalidoTest(){
		try {
			Alunos = new Alunos("100",null,"computação");
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void construtorCursoInvalidoTest(){
		try {
			Alunos = new Alunos("100","andré",null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test 
	void adicionaGrupoNomeInvalidoTest() {
		try {
			Alunos.adicionaGrupo(null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
}
