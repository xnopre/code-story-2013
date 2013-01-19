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

	@Test
	public void test7() {
		ScalaskelMoney money = scalaskelMoneyCalculator.calculate(7);

		ScalaskelMoneyBuilder scalaskelMoneyBuilder = new ScalaskelMoneyBuilder();
		scalaskelMoneyBuilder.addPack().setFoo(7);
		scalaskelMoneyBuilder.addPack().setBar(1);
		ScalaskelMoney expectedMoney = scalaskelMoneyBuilder.build();
		assertEquals(expectedMoney, money);
	}

	@Test
	public void test8() {
		ScalaskelMoney money = scalaskelMoneyCalculator.calculate(8);

		ScalaskelMoneyBuilder scalaskelMoneyBuilder = new ScalaskelMoneyBuilder();
		scalaskelMoneyBuilder.addPack().setFoo(8);
		scalaskelMoneyBuilder.addPack().setBar(1).setFoo(1);
		ScalaskelMoney expectedMoney = scalaskelMoneyBuilder.build();
		assertEquals(expectedMoney, money);
	}

	@Test
	public void test23() {
		ScalaskelMoney money = scalaskelMoneyCalculator.calculate(23);

		ScalaskelMoneyBuilder scalaskelMoneyBuilder = new ScalaskelMoneyBuilder();
		scalaskelMoneyBuilder.addPack().setBaz(0).setQix(0).setBar(0).setFoo(23);
		scalaskelMoneyBuilder.addPack().setBaz(0).setQix(0).setBar(1).setFoo(16);
		scalaskelMoneyBuilder.addPack().setBaz(0).setQix(0).setBar(2).setFoo(9);
		scalaskelMoneyBuilder.addPack().setBaz(0).setQix(0).setBar(3).setFoo(2);
		scalaskelMoneyBuilder.addPack().setBaz(0).setQix(1).setBar(0).setFoo(12);
		scalaskelMoneyBuilder.addPack().setBaz(0).setQix(1).setBar(1).setFoo(5);
		scalaskelMoneyBuilder.addPack().setBaz(0).setQix(2).setBar(0).setFoo(1);
		scalaskelMoneyBuilder.addPack().setBaz(1).setQix(0).setBar(0).setFoo(2);
		ScalaskelMoney expectedMoney = scalaskelMoneyBuilder.build();
		assertEquals(expectedMoney, money);
	}

}
