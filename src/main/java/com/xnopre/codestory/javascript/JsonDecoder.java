package com.xnopre.codestory.javascript;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.xnopre.codestory.CodestoryException;

public class JsonDecoder {

	public JajaRequest decode(String request) {
		JSONArray array = (JSONArray) JSONValue.parse(request);
		if (array == null) {
			throw new CodestoryException("Error parsing JSON request as array : '" + request + "'");
		}
		JajaRequest javaRequest = new JajaRequest();
		for (Iterator<JSONObject> iterator = array.iterator(); iterator.hasNext();) {
			JSONObject obj = iterator.next();
			String vol = (String) obj.get("VOL");
			int depart = ((Long) obj.get("DEPART")).intValue();
			int duree = ((Long) obj.get("DUREE")).intValue();
			int prix = ((Long) obj.get("PRIX")).intValue();
			javaRequest.addVol(new JajaVol(vol, depart, duree, prix));
		}
		return javaRequest;
	}
}
