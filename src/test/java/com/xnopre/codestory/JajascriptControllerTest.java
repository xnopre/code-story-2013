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
	public void testPlusGrosseRequete1() throws IOException {

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

	@Test
	public void testPlusGrosseRequete2() throws IOException {

		/** @formatter:off */
		String request = "[ " +
				"{ \"VOL\": \"difficult-leotard-7\", \"DEPART\": 0, \"DUREE\": 4, \"PRIX\": 12 }, " +
				"{ \"VOL\": \"fierce-casket-98\", \"DEPART\": 1, \"DUREE\": 2, \"PRIX\": 8 }, " +
				"{ \"VOL\": \"brave-chessboard-56\", \"DEPART\": 2, \"DUREE\": 6, \"PRIX\": 7 }, " +
				"{ \"VOL\": \"aggressive-rattan-19\", \"DEPART\": 4, \"DUREE\": 5, \"PRIX\": 19 }, " +
				"{ \"VOL\": \"loud-tonic-42\", \"DEPART\": 5, \"DUREE\": 2, \"PRIX\": 19 }, " +
				"{ \"VOL\": \"dark-knight-35\", \"DEPART\": 5, \"DUREE\": 4, \"PRIX\": 6 }, " +
				"{ \"VOL\": \"innocent-nitrogen-79\", \"DEPART\": 6, \"DUREE\": 2, \"PRIX\": 9 }, " +
				"{ \"VOL\": \"angry-jewel-72\", \"DEPART\": 7, \"DUREE\": 6, \"PRIX\": 3 }, " +
				"{ \"VOL\": \"adventurous-sixpack-36\", \"DEPART\": 9, \"DUREE\": 5, \"PRIX\": 13 }, " +
				"{ \"VOL\": \"creepy-trout-41\", \"DEPART\": 10, \"DUREE\": 2, \"PRIX\": 28 }, " +
				"{ \"VOL\": \"little-tourist-50\", \"DEPART\": 10, \"DUREE\": 4, \"PRIX\": 10 }, " +
				"{ \"VOL\": \"friendly-motorcycle-13\", \"DEPART\": 11, \"DUREE\": 2, \"PRIX\": 1 }, " +
				"{ \"VOL\": \"misty-gym-96\", \"DEPART\": 12, \"DUREE\": 6, \"PRIX\": 3 }, " +
				"{ \"VOL\": \"wrong-polygraph-61\", \"DEPART\": 14, \"DUREE\": 5, \"PRIX\": 12 }, " +
				"{ \"VOL\": \"famous-fuzz-91\", \"DEPART\": 15, \"DUREE\": 2, \"PRIX\": 7 }, " +
				"{ \"VOL\": \"spotless-cricket-74\", \"DEPART\": 15, \"DUREE\": 4, \"PRIX\": 15 }, " +
				"{ \"VOL\": \"careful-tribe-45\", \"DEPART\": 16, \"DUREE\": 2, \"PRIX\": 3 }, " +
				"{ \"VOL\": \"quaint-chimpanzee-28\", \"DEPART\": 17, \"DUREE\": 6, \"PRIX\": 6 }, " +
				"{ \"VOL\": \"teeny-fishbowl-76\", \"DEPART\": 19, \"DUREE\": 5, \"PRIX\": 7 }, " +
				"{ \"VOL\": \"mute-glassware-8\", \"DEPART\": 20, \"DUREE\": 2, \"PRIX\": 19 }, " +
				"{ \"VOL\": \"wonderful-mimosa-91\", \"DEPART\": 20, \"DUREE\": 4, \"PRIX\": 10 }, " +
				"{ \"VOL\": \"miniature-shark-44\", \"DEPART\": 21, \"DUREE\": 2, \"PRIX\": 9 }, " +
				"{ \"VOL\": \"enthusiastic-watchdog-16\", \"DEPART\": 22, \"DUREE\": 6, \"PRIX\": 4 }, " +
				"{ \"VOL\": \"distinct-brush-91\", \"DEPART\": 24, \"DUREE\": 5, \"PRIX\": 5 }, " +
				"{ \"VOL\": \"petite-scalp-67\", \"DEPART\": 25, \"DUREE\": 2, \"PRIX\": 10 }, " +
				"{ \"VOL\": \"tired-public-46\", \"DEPART\": 25, \"DUREE\": 4, \"PRIX\": 14 }, " +
				"{ \"VOL\": \"excited-rash-38\", \"DEPART\": 26, \"DUREE\": 2, \"PRIX\": 7 }, " +
				"{ \"VOL\": \"testy-shrewdness-58\", \"DEPART\": 27, \"DUREE\": 6, \"PRIX\": 4 }, " +
				"{ \"VOL\": \"thankful-hairpiece-63\", \"DEPART\": 29, \"DUREE\": 5, \"PRIX\": 11 }, " +
				"{ \"VOL\": \"mammoth-hoagie-89\", \"DEPART\": 30, \"DUREE\": 2, \"PRIX\": 28 } " +
				"]";
		/** @formatter:on */

		when(mockRequest.getContent()).thenReturn(request);

		jajascriptController.handle(mockRequest, mockResponse);

		String expectedCopiedFromResult = "{\"gain\":135,\"path\":[\"difficult-leotard-7\",\"aggressive-rattan-19\",\"creepy-trout-41\",\"spotless-cricket-74\",\"mute-glassware-8\",\"tired-public-46\",\"mammoth-hoagie-89\"]}";
		assertEquals(expectedCopiedFromResult, getRequestBodyAsString());
	}

	/** @formatter:off */
	
	//[ { "VOL": "tender-platypus-37", "DEPART": 0, "DUREE": 4, "PRIX": 10 }, { "VOL": "puny-uboat-32", "DEPART": 1, "DUREE": 2, "PRIX": 5 }, { "VOL": "helpless-polygraph-79", "DEPART": 2, "DUREE": 6, "PRIX": 3 }, { "VOL": "vast-wintergreen-16", "DEPART": 4, "DUREE": 5, "PRIX": 20 }, { "VOL": "mute-walltowall-45", "DEPART": 5, "DUREE": 2, "PRIX": 18 }, { "VOL": "muddy-tobacco-91", "DEPART": 5, "DUREE": 4, "PRIX": 11 }, { "VOL": "big-revolver-31", "DEPART": 6, "DUREE": 2, "PRIX": 9 }, { "VOL": "graceful-slavery-92", "DEPART": 7, "DUREE": 6, "PRIX": 3 }, { "VOL": "zealous-neighborhood-43", "DEPART": 9, "DUREE": 5, "PRIX": 10 }, { "VOL": "harsh-pun-4", "DEPART": 10, "DUREE": 2, "PRIX": 8 }, { "VOL": "flat-tag-80", "DEPART": 10, "DUREE": 4, "PRIX": 12 }, { "VOL": "fancy-nest-14", "DEPART": 11, "DUREE": 2, "PRIX": 9 }, { "VOL": "tall-wattage-6", "DEPART": 12, "DUREE": 6, "PRIX": 7 }, { "VOL": "super-store-15", "DEPART": 14, "DUREE": 5, "PRIX": 15 }, { "VOL": "cooing-tomato-60", "DEPART": 15, "DUREE": 2, "PRIX": 28 }, { "VOL": "slow-guitarist-43", "DEPART": 15, "DUREE": 4, "PRIX": 7 }, { "VOL": "slow-miter-50", "DEPART": 16, "DUREE": 2, "PRIX": 5 }, { "VOL": "hollow-loiterer-99", "DEPART": 17, "DUREE": 6, "PRIX": 2 }, { "VOL": "thundering-beast-49", "DEPART": 19, "DUREE": 5, "PRIX": 12 }, { "VOL": "cheerful-ash-63", "DEPART": 20, "DUREE": 2, "PRIX": 1 }, { "VOL": "flat-programmer-8", "DEPART": 20, "DUREE": 4, "PRIX": 13 }, { "VOL": "quick-handball-72", "DEPART": 21, "DUREE": 2, "PRIX": 1 }, { "VOL": "nutty-reimbursement-81", "DEPART": 22, "DUREE": 6, "PRIX": 6 }, { "VOL": "flat-warrior-32", "DEPART": 24, "DUREE": 5, "PRIX": 5 }, { "VOL": "dull-watermelon-29", "DEPART": 25, "DUREE": 2, "PRIX": 4 }, { "VOL": "thoughtless-pantsuit-68", "DEPART": 25, "DUREE": 4, "PRIX": 11 }, { "VOL": "fragile-*-34", "DEPART": 26, "DUREE": 2, "PRIX": 3 }, { "VOL": "famous-radiance-87", "DEPART": 27, "DUREE": 6, "PRIX": 4 }, { "VOL": "evil-goatee-87", "DEPART": 29, "DUREE": 5, "PRIX": 15 }, { "VOL": "frail-stipulation-47", "DEPART": 30, "DUREE": 2, "PRIX": 28 }, { "VOL": "zealous-tire-9", "DEPART": 30, "DUREE": 4, "PRIX": 6 }, { "VOL": "successful-earthquake-15", "DEPART": 31, "DUREE": 2, "PRIX": 8 }, { "VOL": "raspy-bacon-67", "DEPART": 32, "DUREE": 6, "PRIX": 1 }, { "VOL": "brief-apathetic-64", "DEPART": 34, "DUREE": 5, "PRIX": 9 }, { "VOL": "mysterious-pesticide-18", "DEPART": 35, "DUREE": 2, "PRIX": 10 }, { "VOL": "faithful-bookcase-57", "DEPART": 35, "DUREE": 4, "PRIX": 11 }, { "VOL": "perfect-fir-53", "DEPART": 36, "DUREE": 2, "PRIX": 1 }, { "VOL": "depressed-goatherd-49", "DEPART": 37, "DUREE": 6, "PRIX": 2 }, { "VOL": "ugliest-physics-43", "DEPART": 39, "DUREE": 5, "PRIX": 14 }, { "VOL": "gigantic-puma-16", "DEPART": 40, "DUREE": 2, "PRIX": 12 }, { "VOL": "troubled-tshirt-75", "DEPART": 40, "DUREE": 4, "PRIX": 8 }, { "VOL": "curious-cage-95", "DEPART": 41, "DUREE": 2, "PRIX": 8 }, { "VOL": "quiet-cheese-97", "DEPART": 42, "DUREE": 6, "PRIX": 3 }, { "VOL": "nutty-opera-40", "DEPART": 44, "DUREE": 5, "PRIX": 13 }, { "VOL": "little-rejection-51", "DEPART": 45, "DUREE": 2, "PRIX": 24 } ]
		
	//INFO: POST:[ { "VOL": "quick-armadillo-20", "DEPART": 0, "DUREE": 4, "PRIX": 7 }, { "VOL": "cruel-nation-3", "DEPART": 1, "DUREE": 2, "PRIX": 7 }, { "VOL": "uninterested-sergeant-6", "DEPART": 2, "DUREE": 6, "PRIX": 3 }, { "VOL": "smoggy-realtor-14", "DEPART": 4, "DUREE": 5, "PRIX": 7 }, { "VOL": "unusual-shrew-52", "DEPART": 5, "DUREE": 2, "PRIX": 20 }, { "VOL": "careful-ref-53", "DEPART": 5, "DUREE": 4, "PRIX": 6 }, { "VOL": "friendly-refugee-38", "DEPART": 6, "DUREE": 2, "PRIX": 6 }, { "VOL": "wandering-joker-54", "DEPART": 7, "DUREE": 6, "PRIX": 7 }, { "VOL": "troubled-harpsichord-88", "DEPART": 9, "DUREE": 5, "PRIX": 10 }, { "VOL": "alive-palace-69", "DEPART": 10, "DUREE": 2, "PRIX": 4 }, { "VOL": "hollow-grater-37", "DEPART": 10, "DUREE": 4, "PRIX": 8 }, { "VOL": "helpful-trait-41", "DEPART": 11, "DUREE": 2, "PRIX": 7 }, { "VOL": "frightened-backpack-26", "DEPART": 12, "DUREE": 6, "PRIX": 4 }, { "VOL": "petite-stucco-33", "DEPART": 14, "DUREE": 5, "PRIX": 7 }, { "VOL": "petite-butter-34", "DEPART": 15, "DUREE": 2, "PRIX": 21 }, { "VOL": "glorious-temperance-43", "DEPART": 15, "DUREE": 4, "PRIX": 8 }, { "VOL": "hissing-hash-51", "DEPART": 16, "DUREE": 2, "PRIX": 7 }, { "VOL": "grotesque-roadrunner-94", "DEPART": 17, "DUREE": 6, "PRIX": 3 }, { "VOL": "encouraging-blood-59", "DEPART": 19, "DUREE": 5, "PRIX": 23 }, { "VOL": "blue-needlepoint-36", "DEPART": 20, "DUREE": 2, "PRIX": 9 }, { "VOL": "impossible-stopover-3", "DEPART": 20, "DUREE": 4, "PRIX": 8 }, { "VOL": "tall-faun-25", "DEPART": 21, "DUREE": 2, "PRIX": 4 }, { "VOL": "ugliest-narcotic-77", "DEPART": 22, "DUREE": 6, "PRIX": 7 }, { "VOL": "successful-mandolin-38", "DEPART": 24, "DUREE": 5, "PRIX": 19 }, { "VOL": "pleasant-seismograph-34", "DEPART": 25, "DUREE": 2, "PRIX": 29 } ]
	//INFO: POST:[ { "VOL": "short-minor-75", "DEPART": 0, "DUREE": 4, "PRIX": 6 }, { "VOL": "nervous-mustache-57", "DEPART": 1, "DUREE": 2, "PRIX": 8 }, { "VOL": "cute-family-99", "DEPART": 2, "DUREE": 6, "PRIX": 3 }, { "VOL": "crazy-terrain-44", "DEPART": 4, "DUREE": 5, "PRIX": 11 }, { "VOL": "friendly-baby-1", "DEPART": 5, "DUREE": 2, "PRIX": 6 }, { "VOL": "lonely-bargain-14", "DEPART": 5, "DUREE": 4, "PRIX": 7 }, { "VOL": "crooked-snowfall-6", "DEPART": 6, "DUREE": 2, "PRIX": 5 }, { "VOL": "nervous-cow-74", "DEPART": 7, "DUREE": 6, "PRIX": 7 }, { "VOL": "awful-typo-41", "DEPART": 9, "DUREE": 5, "PRIX": 6 }, { "VOL": "calm-drummer-5", "DEPART": 10, "DUREE": 2, "PRIX": 2 }, { "VOL": "concerned-birdseed-17", "DEPART": 10, "DUREE": 4, "PRIX": 9 }, { "VOL": "helpful-sharkskin-11", "DEPART": 11, "DUREE": 2, "PRIX": 2 }, { "VOL": "whispering-feet-55", "DEPART": 12, "DUREE": 6, "PRIX": 4 }, { "VOL": "nice-plantain-20", "DEPART": 14, "DUREE": 5, "PRIX": 21 }, { "VOL": "elegant-warhead-75", "DEPART": 15, "DUREE": 2, "PRIX": 30 }, { "VOL": "nasty-fungus-96", "DEPART": 15, "DUREE": 4, "PRIX": 9 }, { "VOL": "curved-teen-1", "DEPART": 16, "DUREE": 2, "PRIX": 10 }, { "VOL": "enchanting-dough-43", "DEPART": 17, "DUREE": 6, "PRIX": 7 }, { "VOL": "different-sunup-15", "DEPART": 19, "DUREE": 5, "PRIX": 11 }, { "VOL": "lovely-bargain-77", "DEPART": 20, "DUREE": 2, "PRIX": 29 }, { "VOL": "scary-sawmill-85", "DEPART": 20, "DUREE": 4, "PRIX": 7 }, { "VOL": "curved-snap-66", "DEPART": 21, "DUREE": 2, "PRIX": 2 }, { "VOL": "weary-prize-68", "DEPART": 22, "DUREE": 6, "PRIX": 6 }, { "VOL": "defeated-vasectomy-26", "DEPART": 24, "DUREE": 5, "PRIX": 4 }, { "VOL": "gifted-video-96", "DEPART": 25, "DUREE": 2, "PRIX": 29 }, { "VOL": "uninterested-valor-41", "DEPART": 25, "DUREE": 4, "PRIX": 10 }, { "VOL": "fierce-ford-62", "DEPART": 26, "DUREE": 2, "PRIX": 2 }, { "VOL": "tender-tedium-21", "DEPART": 27, "DUREE": 6, "PRIX": 4 }, { "VOL": "magnificent-icebox-11", "DEPART": 29, "DUREE": 5, "PRIX": 13 }, { "VOL": "smoggy-pink-8", "DEPART": 30, "DUREE": 2, "PRIX": 10 } ]
	//INFO: POST:[ { "VOL": "depressed-undershirt-25", "DEPART": 0, "DUREE": 4, "PRIX": 12 }, { "VOL": "doubtful-lava-34", "DEPART": 1, "DUREE": 2, "PRIX": 1 }, { "VOL": "helpless-snow-12", "DEPART": 2, "DUREE": 6, "PRIX": 4 }, { "VOL": "disgusted-rumba-14", "DEPART": 4, "DUREE": 5, "PRIX": 9 }, { "VOL": "cruel-lice-88", "DEPART": 5, "DUREE": 2, "PRIX": 26 }, { "VOL": "nutty-teeth-9", "DEPART": 5, "DUREE": 4, "PRIX": 15 }, { "VOL": "mushy-wart-53", "DEPART": 6, "DUREE": 2, "PRIX": 7 }, { "VOL": "clever-iceskate-83", "DEPART": 7, "DUREE": 6, "PRIX": 5 }, { "VOL": "motionless-ignition-40", "DEPART": 9, "DUREE": 5, "PRIX": 13 }, { "VOL": "black-chair-47", "DEPART": 10, "DUREE": 2, "PRIX": 20 }, { "VOL": "busy-honeybee-15", "DEPART": 10, "DUREE": 4, "PRIX": 7 }, { "VOL": "zealous-narrator-63", "DEPART": 11, "DUREE": 2, "PRIX": 9 }, { "VOL": "outrageous-kitty-18", "DEPART": 12, "DUREE": 6, "PRIX": 2 }, { "VOL": "impossible-necktie-53", "DEPART": 14, "DUREE": 5, "PRIX": 8 }, { "VOL": "blushing-barbecue-33", "DEPART": 15, "DUREE": 2, "PRIX": 15 }, { "VOL": "energetic-tenet-16", "DEPART": 15, "DUREE": 4, "PRIX": 10 }, { "VOL": "fast-vendor-84", "DEPART": 16, "DUREE": 2, "PRIX": 4 }, { "VOL": "grotesque-wood-80", "DEPART": 17, "DUREE": 6, "PRIX": 3 }, { "VOL": "homely-square-44", "DEPART": 19, "DUREE": 5, "PRIX": 16 }, { "VOL": "aggressive-minute-73", "DEPART": 20, "DUREE": 2, "PRIX": 2 }, { "VOL": "breakable-topographer-65", "DEPART": 20, "DUREE": 4, "PRIX": 6 }, { "VOL": "tall-comb-65", "DEPART": 21, "DUREE": 2, "PRIX": 1 }, { "VOL": "fair-race-99", "DEPART": 22, "DUREE": 6, "PRIX": 4 }, { "VOL": "teeny-oxen-43", "DEPART": 24, "DUREE": 5, "PRIX": 8 }, { "VOL": "proud-shelter-3", "DEPART": 25, "DUREE": 2, "PRIX": 8 }, { "VOL": "huge-memento-58", "DEPART": 25, "DUREE": 4, "PRIX": 14 }, { "VOL": "bloody-vapidity-53", "DEPART": 26, "DUREE": 2, "PRIX": 3 }, { "VOL": "delightful-knapsack-9", "DEPART": 27, "DUREE": 6, "PRIX": 5 }, { "VOL": "jittery-spat-46", "DEPART": 29, "DUREE": 5, "PRIX": 22 }, { "VOL": "energetic-flick-50", "DEPART": 30, "DUREE": 2, "PRIX": 2 }, { "VOL": "short-standout-99", "DEPART": 30, "DUREE": 4, "PRIX": 15 }, { "VOL": "eager-poultry-79", "DEPART": 31, "DUREE": 2, "PRIX": 8 }, { "VOL": "homely-optometrist-17", "DEPART": 32, "DUREE": 6, "PRIX": 3 }, { "VOL": "powerful-theatre-77", "DEPART": 34, "DUREE": 5, "PRIX": 11 }, { "VOL": "lucky-family-37", "DEPART": 35, "DUREE": 2, "PRIX": 30 } ]
	//INFO: POST:[ { "VOL": "great-illusion-14", "DEPART": 0, "DUREE": 4, "PRIX": 14 }, { "VOL": "helpful-verb-49", "DEPART": 1, "DUREE": 2, "PRIX": 4 }, { "VOL": "zany-purse-46", "DEPART": 2, "DUREE": 6, "PRIX": 4 }, { "VOL": "excited-paintbrush-86", "DEPART": 4, "DUREE": 5, "PRIX": 20 }, { "VOL": "magnificent-zeppelin-6", "DEPART": 5, "DUREE": 2, "PRIX": 10 }, { "VOL": "smiling-overlap-15", "DEPART": 5, "DUREE": 4, "PRIX": 15 }, { "VOL": "inquisitive-clergywoman-13", "DEPART": 6, "DUREE": 2, "PRIX": 1 }, { "VOL": "encouraging-tailor-22", "DEPART": 7, "DUREE": 6, "PRIX": 7 }, { "VOL": "straight-balance-26", "DEPART": 9, "DUREE": 5, "PRIX": 23 }, { "VOL": "charming-beaker-10", "DEPART": 10, "DUREE": 2, "PRIX": 28 }, { "VOL": "plain-flea-30", "DEPART": 10, "DUREE": 4, "PRIX": 11 }, { "VOL": "clumsy-aircraft-23", "DEPART": 11, "DUREE": 2, "PRIX": 10 }, { "VOL": "silly-babysitter-44", "DEPART": 12, "DUREE": 6, "PRIX": 4 }, { "VOL": "steep-photographer-83", "DEPART": 14, "DUREE": 5, "PRIX": 19 }, { "VOL": "strange-bread-87", "DEPART": 15, "DUREE": 2, "PRIX": 14 }, { "VOL": "nervous-quadrilateral-54", "DEPART": 15, "DUREE": 4, "PRIX": 7 }, { "VOL": "vast-lumbar-68", "DEPART": 16, "DUREE": 2, "PRIX": 4 }, { "VOL": "important-notch-90", "DEPART": 17, "DUREE": 6, "PRIX": 3 }, { "VOL": "shy-rosebush-27", "DEPART": 19, "DUREE": 5, "PRIX": 12 }, { "VOL": "excited-gumdrop-94", "DEPART": 20, "DUREE": 2, "PRIX": 17 }, { "VOL": "shallow-prison-68", "DEPART": 20, "DUREE": 4, "PRIX": 6 }, { "VOL": "doubtful-cigar-19", "DEPART": 21, "DUREE": 2, "PRIX": 6 }, { "VOL": "distinct-genie-63", "DEPART": 22, "DUREE": 6, "PRIX": 4 }, { "VOL": "quick-liposuction-62", "DEPART": 24, "DUREE": 5, "PRIX": 14 }, { "VOL": "hilarious-segregation-6", "DEPART": 25, "DUREE": 2, "PRIX": 7 }, { "VOL": "nervous-soda-85", "DEPART": 25, "DUREE": 4, "PRIX": 11 }, { "VOL": "fair-oarlock-23", "DEPART": 26, "DUREE": 2, "PRIX": 5 }, { "VOL": "lucky-rent-21", "DEPART": 27, "DUREE": 6, "PRIX": 3 }, { "VOL": "elegant-top-29", "DEPART": 29, "DUREE": 5, "PRIX": 5 }, { "VOL": "charming-duster-34", "DEPART": 30, "DUREE": 2, "PRIX": 5 }, { "VOL": "exuberant-trio-78", "DEPART": 30, "DUREE": 4, "PRIX": 8 }, { "VOL": "elegant-zeal-47", "DEPART": 31, "DUREE": 2, "PRIX": 2 }, { "VOL": "crooked-oboe-33", "DEPART": 32, "DUREE": 6, "PRIX": 5 }, { "VOL": "puny-serpent-80", "DEPART": 34, "DUREE": 5, "PRIX": 17 }, { "VOL": "shiny-blank-53", "DEPART": 35, "DUREE": 2, "PRIX": 19 }, { "VOL": "quiet-servitude-48", "DEPART": 35, "DUREE": 4, "PRIX": 11 }, { "VOL": "busy-chopsticks-56", "DEPART": 36, "DUREE": 2, "PRIX": 6 }, { "VOL": "spotless-cactus-67", "DEPART": 37, "DUREE": 6, "PRIX": 4 }, { "VOL": "annoying-birdhouse-44", "DEPART": 39, "DUREE": 5, "PRIX": 18 }, { "VOL": "happy-text-1", "DEPART": 40, "DUREE": 2, "PRIX": 15 } ]
	//INFO: POST:[ { "VOL": "tender-platypus-37", "DEPART": 0, "DUREE": 4, "PRIX": 10 }, { "VOL": "puny-uboat-32", "DEPART": 1, "DUREE": 2, "PRIX": 5 }, { "VOL": "helpless-polygraph-79", "DEPART": 2, "DUREE": 6, "PRIX": 3 }, { "VOL": "vast-wintergreen-16", "DEPART": 4, "DUREE": 5, "PRIX": 20 }, { "VOL": "mute-walltowall-45", "DEPART": 5, "DUREE": 2, "PRIX": 18 }, { "VOL": "muddy-tobacco-91", "DEPART": 5, "DUREE": 4, "PRIX": 11 }, { "VOL": "big-revolver-31", "DEPART": 6, "DUREE": 2, "PRIX": 9 }, { "VOL": "graceful-slavery-92", "DEPART": 7, "DUREE": 6, "PRIX": 3 }, { "VOL": "zealous-neighborhood-43", "DEPART": 9, "DUREE": 5, "PRIX": 10 }, { "VOL": "harsh-pun-4", "DEPART": 10, "DUREE": 2, "PRIX": 8 }, { "VOL": "flat-tag-80", "DEPART": 10, "DUREE": 4, "PRIX": 12 }, { "VOL": "fancy-nest-14", "DEPART": 11, "DUREE": 2, "PRIX": 9 }, { "VOL": "tall-wattage-6", "DEPART": 12, "DUREE": 6, "PRIX": 7 }, { "VOL": "super-store-15", "DEPART": 14, "DUREE": 5, "PRIX": 15 }, { "VOL": "cooing-tomato-60", "DEPART": 15, "DUREE": 2, "PRIX": 28 }, { "VOL": "slow-guitarist-43", "DEPART": 15, "DUREE": 4, "PRIX": 7 }, { "VOL": "slow-miter-50", "DEPART": 16, "DUREE": 2, "PRIX": 5 }, { "VOL": "hollow-loiterer-99", "DEPART": 17, "DUREE": 6, "PRIX": 2 }, { "VOL": "thundering-beast-49", "DEPART": 19, "DUREE": 5, "PRIX": 12 }, { "VOL": "cheerful-ash-63", "DEPART": 20, "DUREE": 2, "PRIX": 1 }, { "VOL": "flat-programmer-8", "DEPART": 20, "DUREE": 4, "PRIX": 13 }, { "VOL": "quick-handball-72", "DEPART": 21, "DUREE": 2, "PRIX": 1 }, { "VOL": "nutty-reimbursement-81", "DEPART": 22, "DUREE": 6, "PRIX": 6 }, { "VOL": "flat-warrior-32", "DEPART": 24, "DUREE": 5, "PRIX": 5 }, { "VOL": "dull-watermelon-29", "DEPART": 25, "DUREE": 2, "PRIX": 4 }, { "VOL": "thoughtless-pantsuit-68", "DEPART": 25, "DUREE": 4, "PRIX": 11 }, { "VOL": "fragile-*-34", "DEPART": 26, "DUREE": 2, "PRIX": 3 }, { "VOL": "famous-radiance-87", "DEPART": 27, "DUREE": 6, "PRIX": 4 }, { "VOL": "evil-goatee-87", "DEPART": 29, "DUREE": 5, "PRIX": 15 }, { "VOL": "frail-stipulation-47", "DEPART": 30, "DUREE": 2, "PRIX": 28 }, { "VOL": "zealous-tire-9", "DEPART": 30, "DUREE": 4, "PRIX": 6 }, { "VOL": "successful-earthquake-15", "DEPART": 31, "DUREE": 2, "PRIX": 8 }, { "VOL": "raspy-bacon-67", "DEPART": 32, "DUREE": 6, "PRIX": 1 }, { "VOL": "brief-apathetic-64", "DEPART": 34, "DUREE": 5, "PRIX": 9 }, { "VOL": "mysterious-pesticide-18", "DEPART": 35, "DUREE": 2, "PRIX": 10 }, { "VOL": "faithful-bookcase-57", "DEPART": 35, "DUREE": 4, "PRIX": 11 }, { "VOL": "perfect-fir-53", "DEPART": 36, "DUREE": 2, "PRIX": 1 }, { "VOL": "depressed-goatherd-49", "DEPART": 37, "DUREE": 6, "PRIX": 2 }, { "VOL": "ugliest-physics-43", "DEPART": 39, "DUREE": 5, "PRIX": 14 }, { "VOL": "gigantic-puma-16", "DEPART": 40, "DUREE": 2, "PRIX": 12 }, { "VOL": "troubled-tshirt-75", "DEPART": 40, "DUREE": 4, "PRIX": 8 }, { "VOL": "curious-cage-95", "DEPART": 41, "DUREE": 2, "PRIX": 8 }, { "VOL": "quiet-cheese-97", "DEPART": 42, "DUREE": 6, "PRIX": 3 }, { "VOL": "nutty-opera-40", "DEPART": 44, "DUREE": 5, "PRIX": 13 }, { "VOL": "little-rejection-51", "DEPART": 45, "DUREE": 2, "PRIX": 24 } ]
	
	/** @formatter:on */
}
