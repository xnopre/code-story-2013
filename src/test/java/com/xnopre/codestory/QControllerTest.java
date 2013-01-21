package com.xnopre.codestory;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class QControllerTest extends AbsctractControllerTest {

	private QController qController;

	@Before
	public void setup() throws IOException {
		qController = new QController();
	}

	@Test
	public void testInitialRequest() throws IOException {
		qController.handle(mockRequest, mockResponse, "Quelle est ton adresse email");

		assertEquals("xnopre@gmail.com", getRequestBodyAsString());
	}

	@Test
	public void testHappyRequest() throws IOException {

		qController.handle(mockRequest, mockResponse, "Es tu heureux de participer(OUI/NON)");

		assertEquals("OUI", getRequestBodyAsString());
	}

	@Test
	public void testMailingListRequest() throws IOException {

		qController.handle(mockRequest, mockResponse, "Es tu abonne a la mailing list(OUI/NON)");

		assertEquals("OUI", getRequestBodyAsString());
	}

	@Test
	public void testReadyForMarkDownHttpPostRequest() throws IOException {

		qController.handle(mockRequest, mockResponse, "Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)");

		assertEquals("OUI", getRequestBodyAsString());
	}

	@Test
	public void testAlwaysAnswerYesRequest() throws IOException {

		qController.handle(mockRequest, mockResponse, "Est ce que tu reponds toujours oui(OUI/NON)");

		assertEquals("NON", getRequestBodyAsString());
	}

	@Test
	public void testConfirmEnonce1Recu() throws IOException {

		qController.handle(mockRequest, mockResponse, "As tu bien recu le premier enonce(OUI/NON)");

		assertEquals("OUI", getRequestBodyAsString());
	}

	@Test
	public void testAddition1Request() throws IOException {

		qController.handle(mockRequest, mockResponse, "1 1");

		assertEquals("2", getRequestBodyAsString());
	}

	@Test
	public void testAddition2Request() throws IOException {

		qController.handle(mockRequest, mockResponse, "2 2");

		assertEquals("4", getRequestBodyAsString());
	}

	@Test
	public void testDecimalResultRequest() throws IOException {

		qController.handle(mockRequest, mockResponse, "(1 2)/2");

		assertEquals("1,5", getRequestBodyAsString());
	}

	@Test
	public void testDecimalParameterAndResultWithoutDotZero() throws IOException {

		qController.handle(mockRequest, mockResponse, "1,5*4");

		assertEquals("6", getRequestBodyAsString());
	}

	@Test
	public void testBigDecimalParameterAndResultWithoutDotZeroZero() throws IOException {

		qController.handle(mockRequest, mockResponse, "((1.1 2) 3.14 4 (5 6 7) (8 9 10)*4267387833344334647677634)/2*553344300034334349999000");

		assertEquals("31878018903828899277492024491376690701584023926880", getRequestBodyAsString());
	}

	@Test
	public void testRequestBonneNuit() throws IOException {

		qController.handle(mockRequest, mockResponse, "As tu passe une bonne nuit malgre les bugs de l etape precedente(PAS_TOP/BOF/QUELS_BUGS)");

		assertEquals("QUELS_BUGS", getRequestBodyAsString());
	}

	@Test
	public void testConfirmEnonce2Recu() throws IOException {

		qController.handle(mockRequest, mockResponse, "As tu bien recu le second enonce(OUI/NON)");

		assertEquals("OUI", getRequestBodyAsString());
	}

}
