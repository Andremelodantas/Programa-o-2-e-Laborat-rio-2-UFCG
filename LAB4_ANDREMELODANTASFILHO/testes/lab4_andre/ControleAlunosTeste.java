package lab4_andre;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.BeforeClass;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import LAB4.ControleAlunos;

class ControleAlunosTeste {

	private ControleAlunos controleAlunos = new ControleAlunos();
	
	@BeforeEach
	void preparaAlunos() {
		controleAlunos.cadastro("250","Gabriel Reyes", "Computa��o");
		controleAlunos.cadastro("200","Lili Camposh", "Computa��o");
		controleAlunos.cadastro("202","Angela Ziegler",  "Medicina");
		controleAlunos.cadastro("201","Torbjorn Lindholm", "Engenharia Mec�nica");
	}

	@Test
	void grupoSemRestricaoTest() {
		assertEquals("GRUPO CADASTRADO COM SUCESSO!",controleAlunos.novoGrupo("Programa��o OO"," "),"GRUPO CADASTRADO COM SUCESSO!");
		
	}
	
	@Test
	void grupoComRestricaoTest() {
		assertEquals("GRUPO CADASTRADO COM SUCESSO!",controleAlunos.novoGrupo("Listas","10"),"GRUPO CADASTRADO COM SUCESSO!");
	}
	
	@Test
	void grupoRepeticaoTest() {
		controleAlunos.novoGrupo("Listas","10");
		assertEquals("GRUPO J� CADASTRADO!",controleAlunos.novoGrupo("Listas","10"),"GRUPO J� CADASTRADO!");
	}
	
	@Test
	void alocarAlunoTest() {
		controleAlunos.novoGrupo("Programa��o OO"," ");
		assertEquals("ALUNO ALOCADO!",controleAlunos.alocarAluno("200", "Programa��o OO"),"ALUNO ALOCADO!");
		assertEquals("ALUNO ALOCADO!",controleAlunos.alocarAluno("202", "Programa��o OO"),"ALUNO ALOCADO!");
	}
	
	
	@Test
	void grupoAlunoInexistenteTest() {
		controleAlunos.novoGrupo("Programa��o OO"," ");
		assertEquals("Aluno n�o cadastrado.",controleAlunos.alocarAluno("100", "Programa��o OO"),"Aluno n�o cadastrado.");
	}
	
	@Test
	void grupoInexistenteTest() {
		assertEquals("Grupo n�o cadastrado.",controleAlunos.alocarAluno("200", "Anatomia"),"Grupo n�o cadastrado.");
	}
	
	@Test
	void grupoLimitadoTest() {
		controleAlunos.novoGrupo("Listas","1");
		assertEquals("ALUNO ALOCADO!",controleAlunos.alocarAluno("250", "Listas"),"ALUNO ALOCADO!");
		assertEquals("GRUPO CHEIO.",controleAlunos.alocarAluno("200", "Listas"),"GRUPO CHEIO.");
	}
	
	@Test 
	void pertinenciaGrupoTest() {
		controleAlunos.novoGrupo("Listas","1");
		controleAlunos.alocarAluno("250", "Listas");
		assertEquals("ALUNO PERTENCE AO GRUPO",controleAlunos.pertinenciaGrupo("Listas", "250"),"ALUNO PERTENCE AO GRUPO");
		assertEquals("ALUNO N�O PERTENCE AO GRUPO",controleAlunos.pertinenciaGrupo("Listas", "202"),"ALUNO N�O PERTENCE AO GRUPO");
	}
	
	@Test
	void pertinenciaGrupoInexistenteTest() {
		assertEquals("GRUPO N�O CADASTRADO.",controleAlunos.pertinenciaGrupo("Anatomia", "200"),"GRUPO N�O CADASTRADO.");
	}
	
	@Test
	void pertinenciaAlunoInexistenteTest() {
		controleAlunos.novoGrupo("Programa��o OO"," ");
		assertEquals("ALUNO N�O CADASTRADO.",controleAlunos.pertinenciaGrupo("Programa��o OO", "100"),"ALUNO N�O CADASTRADO.");
	}
	
	@Test
	void exibirGrupoAlunoInexistenteTest() {
		assertEquals("",controleAlunos.olhaGrupos("202"),"");
	}
	
	@Test
	void exibirGruposTest() {
		controleAlunos.novoGrupo("Programa��o OO"," ");
		controleAlunos.novoGrupo("Listas","1");
		controleAlunos.alocarAluno("250", "Programa��o OO");
		controleAlunos.alocarAluno("250", "Listas");
		assertEquals("- PROGRAMA��O OO\n- LISTAS\n",controleAlunos.olhaGrupos("250"),"- PROGRAMA��O OO\n- LISTAS\n");
	}
	
	@Test
	void cadastroAlunoTest() {
		assertEquals("CADASTRO REALIZADO!\n",controleAlunos.cadastro("110", "Andr� Melo", "Medicina"),"CADASTRO REALIZADO!\n");
	}
	
	@Test 
	void cadastroAlunoRepetidoTest() {
		assertEquals("MATR�CULA J� CADASTRADA!\n",controleAlunos.cadastro("250","Gabriel Reyes", "Computa��o"),"MATR�CULA J� CADASTRADA!\n");
	}
	
	@Test
	void consultaAlunoTest() {
		assertEquals("202 - Angela Ziegler - Medicina",controleAlunos.consultaAluno("202"),"202 - Angela Ziegler - Medicina");
	}
	
	@Test
	void consultaAlunoInexistenteTest() {
		assertEquals("Aluno n�o cadastrado.",controleAlunos.consultaAluno("111"),"Aluno n�o cadastrado.");
	}
	
	@Test
	void registraRespostaTest() {
		assertEquals("ALUNO REGISTRADO!",controleAlunos.registraResposta("202"),"ALUNO REGISTRADO!");
	}
	
	@Test
	void registraRespostaAlunoInexistenteTest() {
		assertEquals("Aluno n�o cadastrado.",controleAlunos.registraResposta("111"),"Aluno n�o cadastrado.");
	}
	
	@Test
	void imprimeRespostaTest() {
		controleAlunos.registraResposta("200");
		controleAlunos.registraResposta("202");
		assertEquals("1. 200 - Lili Camposh - Computa��o\n2. 202 - Angela Ziegler - Medicina\n",controleAlunos.imprimeRespostas(),"1. 200 - Lili Camposh - Computa��o\n2. 202 - Angela Ziegler - Medicina\n");
	}
	
	@Test
	void imprimeRespostasVaziaTest() {
		assertEquals("",controleAlunos.imprimeRespostas(),"");
	}
	
	//Testes de parametros invalidos e exce��es na classe
	@Test
	void construtorMatriculaInvalidaTest() {
		try {
			controleAlunos.cadastro(null,"andr�","computa��o");
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void construtorNomeInvalidoTest(){
		try {
			controleAlunos.cadastro("100",null,"computa��o");
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void construtorCursoInvalidoTest(){
		try {
			controleAlunos.cadastro("100","andr�",null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void consultaAlunoMatriculaInvalidaTest() {
		try {
			controleAlunos.consultaAluno(null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void novoGrupoNomeinvalidoTest() {
		try {
			controleAlunos.novoGrupo(null,"1");
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void alocarAlunoMatriculaInvalidaTest() {
		try {
			controleAlunos.alocarAluno(null,"amigos");
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void alocarAlunoGrupoInvalidoTest() {
		try {
			controleAlunos.alocarAluno("200",null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void pertinenciaGrupoInvalido() {
		try {
			controleAlunos.pertinenciaGrupo(null,"100");
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void pertinenciaGrupoAlunoInvalidoTest() {
		try {
			controleAlunos.pertinenciaGrupo("amigos",null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void registraRespostaMatriculaInvalidaTest() {
		try {
			controleAlunos.registraResposta(null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	
	@Test
	void olhaGruposMatriculaInvalidaTest() {
		try {
			controleAlunos.olhaGrupos(null);
			fail("");
		}catch(NullPointerException eae) {
			
		}
	}
	

}
