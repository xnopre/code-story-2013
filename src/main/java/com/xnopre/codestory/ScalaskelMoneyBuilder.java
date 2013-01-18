package com.xnopre.codestory;

import java.util.ArrayList;
import java.util.List;

public class ScalaskelMoneyBuilder {

	private final List<PackBuilder> packBuilders = new ArrayList<PackBuilder>();

	public PackBuilder addPack() {
		PackBuilder packBuilder = new PackBuilder(this);
		packBuilders.add(packBuilder);
		return packBuilder;
	}

	public ScalaskelMoney build() {
		ScalaskelMoney money = new ScalaskelMoney();
		for (PackBuilder packBuilder : packBuilders) {
			money.addPack(packBuilder.buildPack());
		}
		return money;
	}

}
