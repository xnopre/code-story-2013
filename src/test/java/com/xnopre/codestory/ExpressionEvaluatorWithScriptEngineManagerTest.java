package com.xnopre.codestory;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ExpressionEvaluatorWithScriptEngineManagerTest {

	private ExpressionEvaluator expressionEvaluator;

	@Before
	public void setup() {
		expressionEvaluator = new ExpressionEvaluatorWithScriptEngineManager();
	}

	@Test
	@Ignore
	public void test() {
		String result = expressionEvaluator.evaluate("1 1");

		assertEquals(2, result);
	}

}
