package com.xnopre.codestory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ScalaskelMoneyCalculatorTest {

	private ScalaskelMoneyCalculator scalaskelMoneyCalculator;

	@Before
	public void setup() {
		scalaskelMoneyCalculator = new ScalaskelMoneyCalculator();
	}

	@Test
	public void test1() {
		ScalaskelMoney money = scalaskelMoneyCalculator.calculate(1);

		ScalaskelMoney expectedMoney = new ScalaskelMoneyBuilder().addPack().setFoo(1).build();
		assertEquals(expectedMoney, money);
	}

	@Test
	public void test2() {
		ScalaskelMoney money = scalaskelMoneyCalculator.calculate(2);

		ScalaskelMoney expectedMoney = new ScalaskelMoneyBuilder().addPack().setFoo(2).build();
		assertEquals(expectedMoney, money);
	}

}
