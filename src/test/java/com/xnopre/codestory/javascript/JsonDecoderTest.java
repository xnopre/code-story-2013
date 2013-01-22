package com.xnopre.codestory.javascript;

import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class JsonDecoderTest {

	@Test
	public void testDecode() {
		/** @formatter:off */
		String request = "["+ 
				"{\"VOL\": \"MONAD42\", \"DEPART\":0, \"DUREE\":5, \"PRIX\": 10}," +
				"{\"VOL\": \"META18\", \"DEPART\":3, \"DUREE\":7, \"PRIX\": 14}," +
				"{\"VOL\": \"LEGACY01\", \"DEPART\":5, \"DUREE\":9, \"PRIX\": 8}," +
				"{\"VOL\": \"YAGNI17\", \"DEPART\":5, \"DUREE\":9, \"PRIX\": 7}"+
				"]";
		/** @formatter:on */

		JajaRequest javaRequest = new JsonDecoder().decode(request);

		assertEquals(4, javaRequest.getVolsCount());
		JajaVol vol = javaRequest.getVol(1);
		assertEquals("META18", vol.getName());
		assertEquals(3, vol.getDepart());
		assertEquals(7, vol.getDuree());
		assertEquals(14, vol.getPrix());
		// JajaVol[] vols = javaRequest.getVolsArray();
		// JajaVol volFomArray = vols[2];
		List<JajaVol> vols = javaRequest.getVols();
		JajaVol volFomArray = vols.get(2);
		assertEquals("LEGACY01", volFomArray.getName());
		assertEquals(5, volFomArray.getDepart());
		assertEquals(9, volFomArray.getDuree());
		assertEquals(8, volFomArray.getPrix());
	}

}
