package com.xnopre.codestory;

import org.json.simple.JSONValue;

public class ScalaskelMoneyJsonEncoder {

	public String encode(ScalaskelMoney money) {
		return JSONValue.toJSONString(money.asListOfMap());
	}

}
