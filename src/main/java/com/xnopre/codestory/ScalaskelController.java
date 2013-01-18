package com.xnopre.codestory;

import java.io.IOException;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

public class ScalaskelController {

	public void handle(Request request, Response response, String action, String parameter) throws IOException {
		int value = Integer.parseInt(parameter);
		ScalaskelMoney scalaskelMoney = new ScalaskelMoneyCalculator().calculate(value);
		String jsonResult = new ScalaskelMoneyJsonEncoder().encode(scalaskelMoney);
		response.getPrintStream().print(jsonResult);
	}

}
