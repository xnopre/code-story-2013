package com.xnopre.codestory;

public class Main {

	public static void main(String[] args) {
		new XnopreCodestoryWebService(getEnvPort(), new MainController())
				.startAndWait();
	}

	private static int getEnvPort() {
		String envPort = System.getenv("PORT");
		if (envPort == null) {
			throw new IllegalStateException("Environment variable PORT is null");
		}
		if (envPort.length() == 0) {
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

}
