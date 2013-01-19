package com.xnopre.codestory;

import groovy.lang.GroovyRuntimeException;
import groovy.lang.GroovyShell;

public class ExpressionEvaluatorWithGroovy implements ExpressionEvaluator {

	public String evaluate(String expression) {
		try {
			String correctedExpression = expression.replace(" ", "+");
			GroovyShell shell = new GroovyShell();
			String result = shell.evaluate(correctedExpression).toString();
			System.out.println("evaluate : '" + expression + "' --> '" + result + "'");
			return result;
		} catch (GroovyRuntimeException e) {
			throw new CodestoryException("Error evaluating", e);
		}
	}

}
