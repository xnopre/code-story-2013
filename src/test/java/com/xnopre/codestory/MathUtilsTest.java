package com.xnopre.codestory;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class MathUtilsTest {

	@Test
	public void testRemoveZerosAtEnd_0() {
		assertEquals("1500", MathUtils.removeZerosAtEnd("1500"));
	}

	@Test
	public void testRemoveZerosAtEnd_1() {
		assertEquals("6", MathUtils.removeZerosAtEnd("6.0"));
	}

	@Test
	public void testRemoveZerosAtEnd_2() {
		assertEquals("123", MathUtils.removeZerosAtEnd("123.00"));
	}

}
