package com.xnopre.codestory;

import java.io.IOException;

import org.simpleframework.http.Response;

public class Helper {

	public static void fillResponseHeadersForTextPlain(Response response) {
		response.set("Content-Type", "text/plain");
		response.set("Server", "xnopre/CodeStory13");
		long time = System.currentTimeMillis();
		response.setDate("Date", time);
		response.setDate("Last-Modified", time);
	}

	public static void printInBody(Response response, String responseText) throws IOException {
		response.getPrintStream().print(responseText);
	}

}
