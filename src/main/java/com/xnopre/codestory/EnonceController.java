package com.xnopre.codestory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stringtemplate.v4.ST;

public class EnonceController {

	private static final Logger logger = LoggerFactory.getLogger(EnonceController.class);

	public void handle(Request request, Response response, String number) throws IOException {
		System.out.println();
		String htmlTemplate = readFileContent("markdown-model.html");
		String markdownContent = readFileContent("enonces/enonce" + number + ".txt");
		ST template = new ST(htmlTemplate, '$', '$');
		template.add("title", "Enoncé " + number);
		template.add("content", markdownContent);

		response.getPrintStream().append(template.render());
	}

	private String readFileContent(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filename), "utf-8"));
		StringBuffer content = new StringBuffer();
		String line = br.readLine();
		while (line != null) {
			content.append(line);
			content.append("\n");
			line = br.readLine();
		}
		return content.toString();
	}

}
