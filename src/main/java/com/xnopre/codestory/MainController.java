package com.xnopre.codestory;

import java.io.IOException;
import java.io.PrintStream;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainController implements Container {

	private final Logger logger = LoggerFactory.getLogger(MainController.class);

	public void handle(Request request, Response response) {
		logger.info("handle request ...");
		try {
			fillResponseHeaders(response);
			PrintStream body = response.getPrintStream();
			String responseText = getResponseText(request);
			body.print(responseText);
			body.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getResponseText(Request request) throws IOException {
		String q = request.getParameter("q");
		logger.info("'q' parameter in request = '"+q+"'");
		if ("Quelle est ton adresse email".equals(q)) {
			return "xnopre@gmail.com";
		}
		return "CodeStory 2013 by @xnopre";
	}

	private void fillResponseHeaders(Response response) {
		response.set("Content-Type", "text/plain");
		response.set("Server", "xnopre/CodeStory13");
		long time = System.currentTimeMillis();
		response.setDate("Date", time);
		response.setDate("Last-Modified", time);
	}

}
