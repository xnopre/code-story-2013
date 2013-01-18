package com.xnopre.codestory;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import org.simpleframework.http.Path;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainController implements Container {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	public void handle(Request request, Response response) {
		try {
			logger.info("handle request ...");
			Path path = request.getPath();
			logger.info(". Content-Type = " + request.getValue("Content-Type"));
			logger.info(". method = " + request.getMethod());
			logger.info(". path = " + path);
			logger.info(". query = " + request.getQuery());
			try {
				logger.info(". content = " + request.getContent());
			} catch (IOException e) {
				logger.error("Error getting content from request", e);
			}
			try {
				logger.info(". form = " + request.getForm());
			} catch (IOException e) {
				logger.error("Error getting form from request", e);
			}
			if (path != null) {
				String[] pathSegments = path.getSegments();
				if (pathSegments != null && pathSegments.length > 0) {
					if ("scalaskel".equals(pathSegments[0])) {
						new ScalaskelController().handle(request, response, pathSegments[1], pathSegments[2]);
						return;
					}
					System.out.println("pathSegments = " + Arrays.asList(pathSegments));
					// if (pathSegments[0].equals("favicon.ico")) {
					// logger.info("handle request for favicon");
					// try {
					// //
					// IOUtils.copy(getClass().getClassLoader().getResourceAsStream("favicon.ico"),
					// // response.getOutputStream());
					// System.out.println("avant");
					// FileUtils.copyFile(new File("favicon.ico"),
					// response.getOutputStream());
					// System.out.println("apres");
					// // response.getOutputStream().flush();
					// // response.getOutputStream().close();
					// logger.info("request for favicon handled !");
					// } catch (Exception e) {
					// System.out.println("error");
					// e.printStackTrace();
					// logger.error("Error responding favicon", e);
					// }
					// return;
					// }
				}
			}
			fillResponseHeadersForTextPlain(response);
			PrintStream body = response.getPrintStream();
			String responseText = getResponseText(request);
			body.print(responseText);
		} catch (Exception e) {
			logger.error("Error handle request", e);
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				logger.error("Error closing response", e);
			}
		}
	}

	private String getResponseText(Request request) throws IOException {
		String q = request.getParameter("q");
		logger.info("'q' parameter in request = '" + q + "'");
		if ("Quelle est ton adresse email".equals(q)) {
			return "xnopre@gmail.com";
		}
		if ("Es tu heureux de participer(OUI/NON)".equals(q)) {
			return "OUI";
		}
		if ("Es tu abonne a la mailing list(OUI/NON)".equals(q)) {
			return "OUI";
		}
		if ("Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)".equals(q)) {
			return "OUI";
		}
		if ("Est ce que tu reponds toujours oui(OUI/NON)".equals(q)) {
			return "NON";
		}
		if ("As tu bien recu le premier enonce(OUI/NON)".equals(q)) {
			return "OUI";
		}
		return "CodeStory 2013 by @xnopre";
	}

	private void fillResponseHeadersForTextPlain(Response response) {
		response.set("Content-Type", "text/plain");
		response.set("Server", "xnopre/CodeStory13");
		long time = System.currentTimeMillis();
		response.setDate("Date", time);
		response.setDate("Last-Modified", time);
	}

}
