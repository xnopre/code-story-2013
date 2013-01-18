package com.xnopre.codestory;

import java.util.Map;
import java.util.Properties;

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
			envPort = System.getProperty("app.port");
		}
		if (envPort == null || envPort.length() == 0) {
			dumpEnvs();
			dumpProperties();
			throw new IllegalStateException("Environment variable PORT is '"
					+ envPort + "'");
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

	private static void dumpProperties() {
		logger.info("Environment properties :");
		Properties properties = System.getProperties();
		for (Object key : properties.keySet()) {
			logger.info("  . " + key + " --> " + properties.get(key));
		}
	}
}
