package com.xnopre.codestory;

import static junit.framework.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class EnonceControllerTest extends AbsctractControllerTest {

	@Test
	public void testHandle() throws IOException {
		new EnonceController().handle(mockRequest, mockResponse, "1");

		String requestBodyAsString = getRequestBodyAsString();
		assertContains("<xmp", requestBodyAsString);
		assertContains("Votre serveur doit répondre", requestBodyAsString);
	}

	private void assertContains(String sequence, String requestBodyAsString) {
		System.out.println(requestBodyAsString);
		assertTrue("The text does not contains '" + sequence + "'", requestBodyAsString.contains(sequence));
	}

}
