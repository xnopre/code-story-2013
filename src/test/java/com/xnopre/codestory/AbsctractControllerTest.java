package com.xnopre.codestory;

import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

public class AbsctractControllerTest {

	@Mock
	Request mockRequest;

	@Mock
	Response mockResponse;

	private ByteArrayOutputStream bodyArrayStream;

	@Before
	public void setupGlobal() throws IOException {
		MockitoAnnotations.initMocks(this);
		bodyArrayStream = new ByteArrayOutputStream();
		PrintStream bodyPrintStream = new PrintStream(bodyArrayStream);
		when(mockResponse.getPrintStream()).thenReturn(bodyPrintStream);
	}

	String getRequestBodyAsString() {
		return new String(bodyArrayStream.toByteArray());
	}
}
