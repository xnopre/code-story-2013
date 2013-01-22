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
	public void testUnSeulVol() throws IOException {
		when(mockRequest.getContent()).thenReturn("[ {\"VOL\": \"AF514\", \"DEPART\":0, \"DUREE\":5, \"PRIX\": 10} ]");

		jajascriptController.handle(mockRequest, mockResponse);

		assertEquals("{\"gain\":10,\"path\":[\"AF514\"]}", getRequestBodyAsString());
	}

	@Test
	public void testExempleEnonce2() throws IOException {

		/** @formatter:off */
		String request = "["+ 
				"{\"VOL\": \"MONAD42\", \"DEPART\":0, \"DUREE\":5, \"PRIX\": 10}," +
				"{\"VOL\": \"META18\", \"DEPART\":3, \"DUREE\":7, \"PRIX\": 14}," +
				"{\"VOL\": \"LEGACY01\", \"DEPART\":5, \"DUREE\":9, \"PRIX\": 8}," +
				"{\"VOL\": \"YAGNI17\", \"DEPART\":5, \"DUREE\":9, \"PRIX\": 7}"+
				"]";
		/** @formatter:on */

		when(mockRequest.getContent()).thenReturn(request);

		jajascriptController.handle(mockRequest, mockResponse);

		assertEquals("{\"gain\":18,\"path\":[\"MONAD42\",\"LEGACY01\"]}", getRequestBodyAsString());
	}

}
