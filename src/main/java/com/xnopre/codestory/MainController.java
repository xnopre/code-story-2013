package com.xnopre.codestory;

import java.io.IOException;
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
			// try {
			// logger.info(". form = " + request.getForm());
			// } catch (IOException e) {
			// logger.error("Error getting form from request", e);
			// }
			if (path != null) {
				String[] pathSegments = path.getSegments();
				if (pathSegments != null && pathSegments.length > 0) {
					if ("scalaskel".equals(pathSegments[0])) {
						logger.info("call ScalaskelController");
						new ScalaskelController().handle(request, response, pathSegments[1], pathSegments[2]);
						return;
					}
					if ("enonce".equals(pathSegments[0])) {
						logger.info("call EnonceController");
						new EnonceController().handle(request, response, pathSegments[1]);
						return;
					}
					if ("jajascript".equals(pathSegments[0]) && "optimize".equals(pathSegments[1])) {
						logger.info("call JajascriptController");
						new JajascriptController().handle(request, response);
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
			String q = request.getParameter("q");
			if (q != null) {
				new QController().handle(request, response, q);
				return;
			}
			Helper.printInBody(response, "CodeStory 2013 by @xnopre");
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

}
