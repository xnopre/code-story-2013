package com.xnopre.codestory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.simpleframework.http.Path;

public class ScalaskelControllerTest extends AbsctractControllerTest {

	private ScalaskelController scalaskelController;

	@Before
	public void setup() throws IOException {
		scalaskelController = new ScalaskelController();
	}

	@Test
	public void testHappyRequest() throws IOException {
		Path mockPath = mock(Path.class);
		String[] segments = { "scalaskel", "change", "1" };
		when(mockPath.getSegments()).thenReturn(segments);
		when(mockRequest.getPath()).thenReturn(mockPath);

		scalaskelController.handle(mockRequest, mockResponse, "change", "1");

		assertEquals("[{\"foo\":1}]", getRequestBodyAsString());
	}

}
