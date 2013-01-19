package com.xnopre.codestory;

import java.io.IOException;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScalaskelController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	public void handle(Request request, Response response, String action, String parameter) throws IOException {
		int value = Integer.parseInt(parameter);
		ScalaskelMoney scalaskelMoney = new ScalaskelMoneyCalculator().calculate(value);
		String jsonResult = new ScalaskelMoneyJsonEncoder().encode(scalaskelMoney);
		logger.info("action=" + action + ", value=" + value + " --> result='" + jsonResult + "'");
		response.getPrintStream().print(jsonResult);
	}

}
