package com.xnopre.codestory;

import static ch.qos.logback.classic.Level.INFO;
import static junit.framework.Assert.assertEquals;
import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;

public class FunctionalTest {

	private WebTester tester;
	private XnopreCodestoryWebService service;

	@BeforeClass
	public static void classSetUp() {
		((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger("ROOT")
				.setLevel(INFO);
	}

	@Before
	public void prepare() {
		int port = 8081;
		service = new XnopreCodestoryWebService(port, new MainController());
		service.startAndWait();
		tester = new WebTester();
		tester.setBaseUrl("http://localhost:" + port + "/");
	}

	@After
	public void cleanUp() {
		service.stopAndWait();
	}

	@Test
	public void testRootRequest() {
		tester.beginAt("/");
		tester.assertTextPresent("CodeStory 2013 by @xnopre");
	}

	@Test
	public void testInitialCodeStoryRequest() {
		tester.beginAt("/?q=Quelle+est+ton+adresse+email");
		assertEquals("xnopre@gmail.com", tester.getPageSource());
	}
}
