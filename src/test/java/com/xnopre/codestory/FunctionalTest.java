package com.xnopre.codestory;

import static ch.qos.logback.classic.Level.INFO;
import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import net.sourceforge.jwebunit.junit.WebTester;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;

public class FunctionalTest {

	private WebTester tester;
	private XnopreCodestoryWebService service;

	@BeforeClass
	public static void classSetUp() {
		((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger("ROOT").setLevel(INFO);
	}

	@Before
	public void prepare() {
		int port = 8089;
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
	@Ignore
	public void testFavicon() throws MalformedURLException {
		tester.beginAt("/favicon.ico");
		tester.assertDownloadedFileEquals(new URL("file:favicon.ico"));
	}

	@Test
	public void testInitialCodeStoryRequest() {
		tester.beginAt("/?q=Quelle+est+ton+adresse+email");
		assertEquals("xnopre@gmail.com", tester.getPageSource());
	}

	@Test
	public void testScalaskelChange1Request() {
		tester.beginAt("/scalaskel/change/1");
		assertEquals("[{\"foo\":1}]", tester.getPageSource());
	}

	@Test
	public void testCalculRequest() {
		tester.beginAt("/?q=1+1");
		assertEquals("2", tester.getPageSource());
	}

	@Test
	public void testDecimalCalculRequest() {
		// q=(1 2)/2 --> 1,5
		tester.beginAt("/?q=q=%281+2%29%2F2");
		assertEquals("1,5", tester.getPageSource());
	}

	@Test
	public void testMarkdownDisplayEnonce1() {
		tester.beginAt("/enonce/1");
		tester.assertTextPresent("Scalaskel");
	}

}
