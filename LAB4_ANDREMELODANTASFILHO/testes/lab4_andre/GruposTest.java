package lab4_andre;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GruposTest {
	private Grupos Grupos;
	@BeforeEach
	void preparaGrupo() {
		 Grupos = new Grupos("amigos",10);
	}
	
	@Test
	void adicionarGrupoTest() {
		assertEquals("ALUNO ALOCADO!",Grupos.adicionaGrupo("100"),"ALUNO ALOCADO!");
	}
	
	@Test
	void alunoRepetidoTest() {
		Grupos.adicionaGrupo("100");
		assertEquals("Aluno já foi alocado com sucesso para o grupo , não será alocado novamente.",Grupos.adicionaGrupo("100"),"Aluno já foi alocado com sucesso para o grupo , não será alocado novamente.");
	}
	
	@Test
	void verificaAlunoTest() {
		Grupos.adicionaGrupo("100");
		assertEquals("ALUNO PERTENCE AO GRUPO",Grupos.verificaAluno("100"),"ALUNO PERTENCE AO GRUPO");
	}
	
	@Test
	void verificaAlunoInexistenteTest() {
		assertEquals("ALUNO NÃO PERTENCE AO GRUPO",Grupos.verificaAluno("200"),"ALUNO NÃO PERTENCE AO GRUPO");
	}

	@Test
	void vagasTest() {
		assertEquals(10,Grupos.getVagas(),10);
	}
	
	@Test
	void vagasDescontadasTest() {
		Grupos.adicionaGrupo("100");
		Grupos.adicionaGrupo("101");
		assertEquals(8,Grupos.getVagas(),8);
	}
	
	//Testes de parametros invalidos e exceções na classe
	@Test
	void construtorNomeNullTest() {
		try {
			Grupos = new Grupos(null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void construtorTamanhoInvalidoTest() {
		try {
			Grupos = new Grupos("alunos",0);
			fail("");
		}catch(IllegalArgumentException eae) {
			
		}
	}
	
	@Test
	void adicionaGrupoMatriculaInvalidaTest() {
		try {
			Grupos.adicionaGrupo(null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void verificaAlunoMatriculaInvalidaTest() {
		try {
			Grupos.verificaAluno(null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}

}
