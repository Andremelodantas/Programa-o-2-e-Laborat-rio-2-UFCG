import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import agenda.Agenda;

class AgendaTest {
	Agenda agenda = new Agenda();
	@BeforeEach
	void preparaContatoBase() {
		
		agenda.cadastraContato(1, "Andre", "melo", "(83) 1111 1111");
	}
	@Test 
	void TestCadastro(){
		assertEquals("CONTATO CADASTRADO COM SUCESSO!", agenda.cadastraContato(1, "Andre", "Melo", "83 1234-1234"),"Esperando mensagem de sucesso");
	}
	
	@Test
	void TestDuplicado(){
		assertEquals("CONTATO JA CADASTRADO", agenda.cadastraContato(1, "Andre", "melo", "(83) 1111 1111"), "Esperando mensagem de duplicidade");
	}
	
	@Test
	void TestNomeNull() {
		assertEquals("CONTATO INVALIDO", agenda.cadastraContato(1, null, "Melo", "(83) 1111 1111"),"Esperando mensagem de erro");
	}
	@Test
	void TestTelefoneNull() {
		assertEquals("CONTATO INVALIDO", agenda.cadastraContato(1, "Andre", "Melo", null),"Esperando mensagem de erro");
	}
	
	@Test
	void TestAdicionaFavoritos() {
		assertEquals("CONTATO FAVORITADO NA POSIÇÃO 1!", agenda.cadastraFavoritos(1, 1), "Esperando mensagem de sucesso");
	}
	
	@Test
	void TestDuplicidadeFavorito() {
		agenda.cadastraFavoritos(1, 1);
		assertEquals("Não é possivel adicionar, pois o contato ja esta adicionado aos favoritos.", agenda.cadastraFavoritos(1, 2), "Esperando mensagem de erro");
		
	}
	
	@Test 
	void TestPosicaoFavoritoAcima() {
		assertEquals("Posicao invalida.", agenda.cadastraFavoritos(1, 0), "Esperando mensagem de erro");
	}
	
	@Test 
	void TestPosicaoFavoritoAbaixo() {
		assertEquals("Posicao invalida.", agenda.cadastraFavoritos(1, 11), "Esperando mensagem de erro");
	}
	
	@Test
	void TestAdicionaTags() {
		assertEquals("Tag ufcg, adicionado na posicao 5", agenda.adicionaTags("1","ufcg",5), "Esperando mensagem de sucesso");
	}
	
	@Test
	void TestPosicaoTagAcima() {
		assertEquals("Posição da tag invalida, só é permitido entre 1 e 5.", agenda.adicionaTags("1", "ufcg", 6));
	}
	@Test
	void TestPosicaoTagAbaixo() {
		assertEquals("Posição da tag invalida, só é permitido entre 1 e 5.", agenda.adicionaTags("1", "ufcg", 0));
	}
}
