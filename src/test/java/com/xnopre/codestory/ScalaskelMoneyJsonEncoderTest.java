package com.xnopre.codestory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ScalaskelMoneyJsonEncoderTest {

	private ScalaskelMoneyJsonEncoder scalaskelMoneyJsonEncoder;

	@Before
	public void setup() {
		scalaskelMoneyJsonEncoder = new ScalaskelMoneyJsonEncoder();
	}

	@Test
	public void test1() {
		ScalaskelMoney money = new ScalaskelMoneyBuilder().addPack().setFoo(456).build();

		String jsonString = scalaskelMoneyJsonEncoder.encode(money);

		assertEquals("[{\"foo\":456}]", jsonString);
	}

	@Test
	public void test2() {

		ScalaskelMoney money = new ScalaskelMoneyBuilder().addPack().setFoo(2).setBar(3).setQix(4).setBaz(5).addPack().setFoo(456).build();

		String jsonString = scalaskelMoneyJsonEncoder.encode(money);

		assertEquals("[{\"foo\":2,\"bar\":3,\"qix\":4,\"baz\":5},{\"foo\":456}]", jsonString);
	}

}
