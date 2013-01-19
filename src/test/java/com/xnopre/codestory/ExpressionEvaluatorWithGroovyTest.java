package com.xnopre.codestory;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ExpressionEvaluatorWithGroovyTest {

	private ExpressionEvaluator expressionEvaluatorWithGroovy;

	@Before
	public void setup() {
		expressionEvaluatorWithGroovy = new ExpressionEvaluatorWithGroovy();
	}

	@Test
	public void test_1_1() {
		assertEquals("2", expressionEvaluatorWithGroovy.evaluate("1 1"));
	}

	@Test
	public void test_2_2() {
		assertEquals("4", expressionEvaluatorWithGroovy.evaluate("2 2"));
	}

}
