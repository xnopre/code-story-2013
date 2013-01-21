package com.xnopre.codestory;

import java.io.IOException;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	public void handle(Request request, Response response, String q) throws IOException {
		Helper.fillResponseHeadersForTextPlain(response);
		String responseText = getResponseText(q);
		logger.info("response = '" + responseText + "'");
		Helper.printInBody(response, responseText);
	}

	private String getResponseText(String q) throws IOException {
		logger.info("'q' parameter in request = '" + q + "'");
		if (q.equals("Quelle est ton adresse email")) {
			return "xnopre@gmail.com";
		}
		if (q.equals("Es tu heureux de participer(OUI/NON)")) {
			return "OUI";
		}
		if (q.equals("Es tu abonne a la mailing list(OUI/NON)")) {
			return "OUI";
		}
		if (q.equals("Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)")) {
			return "OUI";
		}
		if (q.equals("Est ce que tu reponds toujours oui(OUI/NON)")) {
			return "NON";
		}
		if (q.equals("As tu bien recu le premier enonce(OUI/NON)")) {
			return "OUI";
		}

		try {
			String mathExpressionWithDot = q.replace(",", ".");
			String result = new ExpressionEvaluatorWithGroovy().evaluate(mathExpressionWithDot).toString();
			if (result.endsWith(".0")) {
				result = result.substring(0, result.length() - 2);
			}
			return result.replace(".", ",");
		} catch (CodestoryException e) {
			logger.error("Error trying to evaluate", e);
		}

		return "What ?";
	}
}
