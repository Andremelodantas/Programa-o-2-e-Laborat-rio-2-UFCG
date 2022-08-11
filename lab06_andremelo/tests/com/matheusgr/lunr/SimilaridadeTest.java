package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimilaridadeTest extends BaseTest{


	@Test
	void similaridadeTest() {
		assertEquals(0.3333333333333333,this.similaridadeController.similaridade(TEXTO1_ID, TEXTO2_ID));
	}

}
