package com.xnopre.codestory;

import groovy.lang.GroovyShell;

public class ExpressionEvaluatorWithGroovy implements ExpressionEvaluator {

	public String evaluate(String expression) {
		String correctedExpression = expression.replace(" ", "+");
		GroovyShell shell = new GroovyShell();
		return shell.evaluate(correctedExpression).toString();
	}

}
