package com.xnopre.codestory.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;

import com.xnopre.codestory.CodestoryException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MySystem.class })
public class TimeTracerTest {

	@Test
	public void testInit() {
		mockStatic(MySystem.class);
		when(MySystem.currentTimeMillis()).thenReturn(1000L);

		TimeTracer timeTracer = new TimeTracer(null);
		timeTracer.init();

		verifyStatic();
		MySystem.currentTimeMillis();
	}

	@Test
	public void testLog() {
		mockStatic(MySystem.class);
		Mockito.when(MySystem.currentTimeMillis()).thenReturn(1000L).thenReturn(7000L);
		Logger mockLogger = mock(Logger.class);

		TimeTracer timeTracer = new TimeTracer(mockLogger);
		timeTracer.init();
		timeTracer.log("Mon action");

		Mockito.verify(mockLogger).info("+6000 : Mon action");
	}

	@Test(expected = CodestoryException.class)
	public void testThrowExceptionIfNoInitInit() {
		TimeTracer timeTracer = new TimeTracer(mock(Logger.class));
		timeTracer.log("bla bla bla");
	}
}
