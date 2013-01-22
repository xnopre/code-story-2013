package com.xnopre.codestory.javascript;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONValue;

public class JsonEncoder {

	public String encode(JajaPath path) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("gain", path.getGain());
		map.put("path", path.getVolsNames());
		return JSONValue.toJSONString(map);
	}

}
