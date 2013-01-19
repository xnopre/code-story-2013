package com.xnopre.codestory;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class MainControllerTest extends AbsctractControllerTest {

	private MainController mainController;

	@Before
	public void setup() throws IOException {
		mainController = new MainController();
	}

	@Test
	public void testBodyStreamClosed() throws IOException {
		PrintStream mockBodyPrintStream = mock(PrintStream.class);
		when(mockResponse.getPrintStream()).thenReturn(mockBodyPrintStream);

		mainController.handle(mockRequest, mockResponse);

		verify(mockResponse).close();
	}

	@Test
	public void testBasicRequest() throws IOException {

		mainController.handle(mockRequest, mockResponse);

		assertTrue(getRequestBodyAsString().contains("CodeStory 2013 by @xnopre"));
	}

	@Test
	public void testHappyRequest() throws IOException {
		when(mockRequest.getParameter("q")).thenReturn("N'importe quoi");

		mainController.handle(mockRequest, mockResponse);

		assertEquals("What ?", getRequestBodyAsString());
	}

}
