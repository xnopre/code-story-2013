package com.xnopre.codestory;

public class Main {

	public static void main(String[] args) {
		new XnopreCodestoryWebService(8081, new MainController()).startAndWait();
	}

}
