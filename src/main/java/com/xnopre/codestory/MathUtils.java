package com.xnopre.codestory;

public class MathUtils {

	public static String removeZerosAtEnd(String value) {
		if (value.contains(".")) {
			while (value.endsWith("0")) {
				value = value.substring(0, value.length() - 1);
			}
			if (value.endsWith(".")) {
				value = value.substring(0, value.length() - 1);
			}
		}
		return value;
	}

}
