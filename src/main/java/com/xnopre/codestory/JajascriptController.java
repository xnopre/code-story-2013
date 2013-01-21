package com.xnopre.codestory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JajascriptController {

	private static final Logger logger = LoggerFactory.getLogger(JajascriptController.class);

	public void handle(Request request, Response response) throws IOException {
		String content = request.getContent();
		JSONArray array = (JSONArray) JSONValue.parse(content);
		JSONObject obj = (JSONObject) array.get(0);
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("gain", obj.get("PRIX"));
		List<String> path = new ArrayList<String>();
		path.add((String) obj.get("VOL"));
		result.put("path", path);
		response.getPrintStream().print(JSONValue.toJSONString(result));
	}

}
