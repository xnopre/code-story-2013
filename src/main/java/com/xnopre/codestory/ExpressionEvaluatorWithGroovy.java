package com.xnopre.codestory;

import groovy.lang.GroovyRuntimeException;
import groovy.lang.GroovyShell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpressionEvaluatorWithGroovy implements ExpressionEvaluator {

	private static final Logger logger = LoggerFactory.getLogger(ExpressionEvaluatorWithGroovy.class);

	public String evaluate(String expression) {
		try {
			String correctedExpression = expression.replace(" ", "+");
			GroovyShell shell = new GroovyShell();
			String result = shell.evaluate(correctedExpression).toString();
			logger.info("evaluate with Groovy : '" + expression + "' --> '" + result + "'");
			return result;
		} catch (GroovyRuntimeException e) {
			throw new CodestoryException("Error evaluating", e);
		}
	}

}
