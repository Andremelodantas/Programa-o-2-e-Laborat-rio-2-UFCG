import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class termometrotest {

	@Test
	void testMedicaoOk() {
		this.temp=30;
		assertEquals("OK",this.Termometro.medicao(), "Esperando obter ok");
	}
	
	@Test 
	void testMedicaoQuente() {
		this.temp=31;
		assertEquals("QUENTE",this.Termometro.medicao(), "Esperando obter quente");
	}
	
	@Test 
	void testMedicaoFrio() {
		this.temp=10;
		assertEquals("Frio",this.Termometro.medicao(), "Esperando obter frio");
	}
}
