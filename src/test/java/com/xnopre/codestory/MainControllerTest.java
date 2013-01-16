package com.xnopre.codestory;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

import com.xnopre.codestory.MainController;

public class MainControllerTest {

	private MainController mainController;
	
	@Mock
	private Request mockRequest;
	
	@Mock
	private Response mockResponse;

	private ByteArrayOutputStream bodyArrayStream;
	
	@Before
	public void setup() throws IOException {
		mainController = new MainController();
		MockitoAnnotations.initMocks(this);
		bodyArrayStream = new ByteArrayOutputStream();
		PrintStream bodyPrintStream = new PrintStream(bodyArrayStream);
		when(mockResponse.getPrintStream()).thenReturn(bodyPrintStream);
	}
	
	@Test
	public void testBodyStreamClosed() throws IOException {
		PrintStream mockBodyPrintStream = mock(PrintStream.class);
		when(mockResponse.getPrintStream()).thenReturn(mockBodyPrintStream);
		
		mainController.handle(mockRequest, mockResponse);
		
		verify(mockBodyPrintStream).close();
	}

	@Test
	public void testBasicRequest() throws IOException {
		
		mainController.handle(mockRequest, mockResponse);
		
		assertTrue(getRequestBodyAsString().contains("CodeStory 2013 by @xnopre"));
	}
	
	@Test
	public void testInitialRequest() throws IOException {
		when(mockRequest.getParameter("q")).thenReturn("Quelle est ton adresse email");
		
		mainController.handle(mockRequest, mockResponse);
		
		assertEquals("xnopre@gmail.com", getRequestBodyAsString());
	}

	// Private methods
	
	private String getRequestBodyAsString() {
		return new String(bodyArrayStream.toByteArray());
	}
	
}
