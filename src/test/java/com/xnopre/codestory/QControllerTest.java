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
	public void testConfirmEnonce1Request() throws IOException {

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
	public void testDecimalParameterRequest() throws IOException {

		qController.handle(mockRequest, mockResponse, "1,5*4");

		assertEquals("6", getRequestBodyAsString());
	}

}
