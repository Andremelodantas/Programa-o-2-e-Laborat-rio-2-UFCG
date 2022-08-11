import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import agenda.Contato;

class ContatoTest {

	Contato[] Contato = new Contato[101];
	@BeforeEach
	void preparaContato() {
		this.Contato[1] = new Contato("Matheus", "Gaudencio", "555-5551");
		this.Contato[1].registraTags(1, "ufcg");
		this.Contato[1].registraTags(2, "aluno");
		this.Contato[1].registraTags(5, "simpatico");
	}
	
	@Test
	void testNomeCompleto() {
        assertEquals( "Matheus Gaudencio", this.Contato[1].getContato(), "Esperando obter o nome completo");
	}
	
	@Test
	void testTags() {
		assertEquals( "ufcg aluno simpatico", this.Contato[1].getTags(), "Esperando obter todas as tags");
		
	}

	@Test
	void testNomeNull() {
	 try {
	     Contato[1]  = new Contato(null, "Gaudencio", "21010000");
	     fail("Era esperado exceção ao passar código nulo");
	  } catch (NullPointerException npe) {

	  }
	}
	
	@Test
	void testTelefoneNull() {
	 try {
	     Contato[1]  = new Contato("Andre", "Gaudencio", null);
	     fail("Era esperado exceção ao passar código nulo");
	  } catch (NullPointerException npe) {

	  }
	}
	
	@Test
	void testNomeinvalido() {
	 try {
	     Contato[1]  = new Contato("    ", "Gaudencio", "21010000");
	     fail("Era esperado exceção ao passar código nulo");
	  } catch (IllegalArgumentException npe) {

	  }
	}
}
