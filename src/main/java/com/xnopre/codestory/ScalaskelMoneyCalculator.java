package com.xnopre.codestory;

public class ScalaskelMoneyCalculator {

	public ScalaskelMoney calculate(int value) {
		ScalaskelMoneyBuilder scalaskelMoneyBuilder = new ScalaskelMoneyBuilder();
		PackBuilder packBuilder = scalaskelMoneyBuilder.addPack();
		packBuilder.setFoo(1);
		return packBuilder.build();
	}

}
