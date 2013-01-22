package com.xnopre.codestory;

import java.io.IOException;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xnopre.codestory.javascript.JajaPath;
import com.xnopre.codestory.javascript.JajaRequest;
import com.xnopre.codestory.javascript.JsonDecoder;
import com.xnopre.codestory.javascript.JsonEncoder;
import com.xnopre.codestory.javascript.PathCalculator;

public class JajascriptController {

	private static final Logger logger = LoggerFactory.getLogger(JajascriptController.class);

	public void handle(Request request, Response response) throws IOException {
		String content = request.getContent();
		JajaRequest jajaRequest = new JsonDecoder().decode(content);
		JajaPath jajaPath = new PathCalculator().calculate(jajaRequest);
		String resultJsonStr = new JsonEncoder().encode(jajaPath);
		logger.info("Jajascript response : " + resultJsonStr);
		response.getPrintStream().print(resultJsonStr);
	}

}
