package com.xnopre.codestory;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		new XnopreCodestoryWebService(getEnvPort(), new MainController())
				.startAndWait();
	}

	private static int getEnvPort() {
		String envPort = System.getenv("PORT");
		if (envPort == null) {
			dumpEnvs();
			throw new IllegalStateException("Environment variable PORT is null");
		}
		if (envPort.length() == 0) {
			dumpEnvs();
			throw new IllegalStateException(
					"Environment variable PORT is empty");
		}
		try {
			return Integer.parseInt(envPort);
		} catch (NumberFormatException e) {
			throw new IllegalStateException(
					"Environment variable PORT is not an integer", e);
		}
	}

	private static void dumpEnvs() {
		logger.info("Environment variables :");
		Map<String, String> envMap = System.getenv();
		for (String key : envMap.keySet()) {
			logger.info("  . " + key + " --> " + envMap.get(key));
		}
	}

}
