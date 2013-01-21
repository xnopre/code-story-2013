package com.xnopre.codestory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class JajascriptControllerTest extends AbsctractControllerTest {

	private JajascriptController jajascriptController;

	@Before
	public void setup() throws IOException {
		jajascriptController = new JajascriptController();
	}

	@Test
	public void test() throws IOException {
		when(mockRequest.getContent()).thenReturn("[ {\"VOL\": \"AF514\", \"DEPART\":0, \"DUREE\":5, \"PRIX\": 10} ]");

		jajascriptController.handle(mockRequest, mockResponse);

		assertEquals("{\"gain\":10,\"path\":[\"AF514\"]}", getRequestBodyAsString());
	}

}
