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

	@Test
	public void testRequeteFromLog1() throws IOException {

		/** @formatter:off */
		String request = "[ { \"VOL\": \"funny-swordplay-12\", \"DEPART\": 0, \"DUREE\": 4, \"PRIX\": 9 }, { \"VOL\": \"angry-bonus-40\", \"DEPART\": 1, \"DUREE\": 2, \"PRIX\": 5 }, { \"VOL\": \"silly-vogue-68\", \"DEPART\": 2, \"DUREE\": 6, \"PRIX\": 6 }, { \"VOL\": \"faint-stockpile-19\", \"DEPART\": 4, \"DUREE\": 5, \"PRIX\": 6 }, { \"VOL\": \"old-spectrum-30\", \"DEPART\": 5, \"DUREE\": 2, \"PRIX\": 10 } ]";
		/** @formatter:on */

		when(mockRequest.getContent()).thenReturn(request);

		jajascriptController.handle(mockRequest, mockResponse);

		assertEquals("{\"gain\":19,\"path\":[\"funny-swordplay-12\",\"old-spectrum-30\"]}", getRequestBodyAsString());
	}

	@Test
	public void testRequeteFromLog2() throws IOException {

		/** @formatter:off */
		String request = "[ { \"VOL\": \"determined-fig-4\", \"DEPART\": 0, \"DUREE\": 4, \"PRIX\": 9 }, { \"VOL\": \"attractive-sidewalk-98\", \"DEPART\": 1, \"DUREE\": 2, \"PRIX\": 8 }, { \"VOL\": \"shy-utensil-58\", \"DEPART\": 2, \"DUREE\": 6, \"PRIX\": 7 }, { \"VOL\": \"ill-beam-7\", \"DEPART\": 4, \"DUREE\": 5, \"PRIX\": 5 }, { \"VOL\": \"victorious-quintessence-52\", \"DEPART\": 5, \"DUREE\": 2, \"PRIX\": 16 }, { \"VOL\": \"ancient-repression-53\", \"DEPART\": 5, \"DUREE\": 4, \"PRIX\": 10 }, { \"VOL\": \"pleasant-garlic-38\", \"DEPART\": 6, \"DUREE\": 2, \"PRIX\": 7 }, { \"VOL\": \"great-saddle-98\", \"DEPART\": 7, \"DUREE\": 6, \"PRIX\": 1 }, { \"VOL\": \"lazy-stoicism-3\", \"DEPART\": 9, \"DUREE\": 5, \"PRIX\": 15 }, { \"VOL\": \"inexpensive-pedigree-39\", \"DEPART\": 10, \"DUREE\": 2, \"PRIX\": 3 } ]";
		/** @formatter:on */

		when(mockRequest.getContent()).thenReturn(request);

		jajascriptController.handle(mockRequest, mockResponse);

		assertEquals("{\"gain\":40,\"path\":[\"determined-fig-4\",\"victorious-quintessence-52\",\"lazy-stoicism-3\"]}", getRequestBodyAsString());
	}

	@Test
	public void testPlusGrosseRequete() throws IOException {

		/** @formatter:off */
		String request = "[ " +
				"{ \"VOL\": \"dull-liver-51\", \"DEPART\": 0, \"DUREE\": 4, \"PRIX\": 9 }, " +
				"{ \"VOL\": \"annoying-lizard-71\", \"DEPART\": 1, \"DUREE\": 2, \"PRIX\": 3 }, " +
				"{ \"VOL\": \"depressed-letter-22\", \"DEPART\": 2, \"DUREE\": 6, \"PRIX\": 2 }, " +
				"{ \"VOL\": \"shy-sleepyhead-43\", \"DEPART\": 4, \"DUREE\": 5, \"PRIX\": 16 }, " +
				"{ \"VOL\": \"repulsive-billionaire-27\", \"DEPART\": 5, \"DUREE\": 2, \"PRIX\": 19 }, " +
				"{ \"VOL\": \"blushing-fastfood-76\", \"DEPART\": 5, \"DUREE\": 4, \"PRIX\": 15 }, " +
				"{ \"VOL\": \"quiet-bow-72\", \"DEPART\": 6, \"DUREE\": 2, \"PRIX\": 9 }, " +
				"{ \"VOL\": \"shrill-slyness-56\", \"DEPART\": 7, \"DUREE\": 6, \"PRIX\": 6 }, " +
				"{ \"VOL\": \"stormy-deck-4\", \"DEPART\": 9, \"DUREE\": 5, \"PRIX\": 15 }, " +
				"{ \"VOL\": \"shiny-comma-26\", \"DEPART\": 10, \"DUREE\": 2, \"PRIX\": 25 }, " +
				"{ \"VOL\": \"bored-salesclerk-97\", \"DEPART\": 10, \"DUREE\": 4, \"PRIX\": 13 }, " +
				"{ \"VOL\": \"mute-slang-60\", \"DEPART\": 11, \"DUREE\": 2, \"PRIX\": 1 }, " +
				"{ \"VOL\": \"swift-heater-68\", \"DEPART\": 12, \"DUREE\": 6, \"PRIX\": 2 }, " +
				"{ \"VOL\": \"shallow-percussionist-98\", \"DEPART\": 14, \"DUREE\": 5, \"PRIX\": 10 }, " +
				"{ \"VOL\": \"fine-fleece-12\", \"DEPART\": 15, \"DUREE\": 2, \"PRIX\": 1 } " +
				"]";
		/** @formatter:on */

		when(mockRequest.getContent()).thenReturn(request);

		jajascriptController.handle(mockRequest, mockResponse);

		String expectedCopiedFromResult = "{\"gain\":63,\"path\":[\"dull-liver-51\",\"repulsive-billionaire-27\",\"shiny-comma-26\",\"shallow-percussionist-98\"]}";
		assertEquals(expectedCopiedFromResult, getRequestBodyAsString());
	}

}
