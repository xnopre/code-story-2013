package com.xnopre.codestory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.net.InetSocketAddress;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.simpleframework.http.core.Container;
import org.simpleframework.transport.connect.SocketConnection;

import com.google.common.util.concurrent.Service.State;
import com.xnopre.codestory.MainController;
import com.xnopre.codestory.XnopreCodestoryWebService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({XnopreCodestoryWebService.class})
public class XnopreCodestoryWebServiceTest {

	private static final int PORT = 8084;

	@Test
	public void testDoStart() throws Exception {

		final MainController mainController = PowerMockito.mock(MainController.class);
		XnopreCodestoryWebService xnopreCodestoryWebService = new XnopreCodestoryWebService(PORT, mainController);
		SocketConnection mockSocketConnection = PowerMockito.mock(SocketConnection.class);
		whenNew(SocketConnection.class).withArguments(mainController).thenReturn(mockSocketConnection);
		
		xnopreCodestoryWebService.startAndWait();
		
		assertEquals(State.RUNNING, xnopreCodestoryWebService.state());
		verify(mockSocketConnection).connect(new InetSocketAddress(PORT));
		verifyNew(SocketConnection.class).withArguments(mainController);
	}
	
	@Test
	public void testDoStop() throws Exception {
		
		final MainController mainController = PowerMockito.mock(MainController.class);
		XnopreCodestoryWebService xnopreCodestoryWebService = new XnopreCodestoryWebService(PORT, mainController);
		SocketConnection mockSocketConnection = PowerMockito.mock(SocketConnection.class);
		whenNew(SocketConnection.class).withArguments(mainController).thenReturn(mockSocketConnection);
		xnopreCodestoryWebService.startAndWait();
		
		xnopreCodestoryWebService.stopAndWait();
		
		assertEquals(State.TERMINATED, xnopreCodestoryWebService.state());
		verify(mockSocketConnection).close();
	}
}
