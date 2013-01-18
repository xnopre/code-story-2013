package com.xnopre.codestory;

import org.junit.Assert;
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
		Assert.assertEquals(expectedMoney, money);
	}

}
