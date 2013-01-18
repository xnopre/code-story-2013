package com.xnopre.codestory;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class ScalaskelMoneyBuilderTest {

	@Test
	public void testEmpty() {
		ScalaskelMoney money = new ScalaskelMoneyBuilder().build();

		assertEquals(0, money.packCount());
	}

	@Test
	public void testFull() {
		ScalaskelMoney money = new ScalaskelMoneyBuilder().addPack().setFoo(2).setBar(3).setQix(4).setBaz(5).addPack().setFoo(456).build();

		assertEquals(2, money.packCount());
		Pack pack0 = money.getPack(0);
		assertEquals(2, pack0.getFoo());
		assertEquals(3, pack0.getBar());
		assertEquals(4, pack0.getQix());
		assertEquals(5, pack0.getBaz());
		Pack pack1 = money.getPack(1);
		assertEquals(456, pack1.getFoo());
		assertEquals(0, pack1.getBar());
		assertEquals(0, pack1.getQix());
		assertEquals(0, pack1.getBaz());
	}
}
