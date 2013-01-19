package com.xnopre.codestory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpressionEvaluatorWithScriptEngineManager implements ExpressionEvaluator {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	public String evaluate(String expression) {
		try {
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			Object result = engine.eval(expression.replace(" ", "+"));
			try {
				int value = Integer.parseInt(result.toString());
				return String.valueOf(value);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			return result.toString();
		} catch (ScriptException e) {
			logger.error("Error evaluting expression '" + expression + "'", e);
			throw new CodestoryException("Error evaluting expression", e);
		}
	}

}
