package com.xnopre.codestory;

public class ScalaskelMoneyCalculator {

	private static final int BAZ_VALUE = 21;
	private static final int QIX_VALUE = 11;
	private static final int BAR_VALUE = 7;

	public ScalaskelMoney calculate(int value) {
		ScalaskelMoneyBuilder scalaskelMoneyBuilder = new ScalaskelMoneyBuilder();
		int nbBazMax = value / BAZ_VALUE;
		for (int nbBaz = 0; nbBaz <= nbBazMax; nbBaz++) {
			int valueWithoutBaz = value - nbBaz * BAZ_VALUE;
			int nbQixMax = valueWithoutBaz / QIX_VALUE;
			for (int nbQix = 0; nbQix <= nbQixMax; nbQix++) {
				int valueWithoutQix = valueWithoutBaz - nbQix * QIX_VALUE;
				int nbBarMax = valueWithoutQix / BAR_VALUE;
				for (int nbBar = 0; nbBar <= nbBarMax; nbBar++) {
					int valueWithoutBar = valueWithoutQix - nbBar * BAR_VALUE;
					int nbFoo = valueWithoutBar;
					scalaskelMoneyBuilder.addPack().setFoo(nbFoo).setBar(nbBar).setQix(nbQix).setBaz(nbBaz);
				}
			}
		}
		return scalaskelMoneyBuilder.build();
	}

}
