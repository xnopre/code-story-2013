package com.xnopre.codestory;

public class PackBuilder {

	private final ScalaskelMoneyBuilder scalaskelMoneyBuilder;
	private final Pack pack;

	public PackBuilder(ScalaskelMoneyBuilder scalaskelMoneyBuilder) {
		this.scalaskelMoneyBuilder = scalaskelMoneyBuilder;
		this.pack = new Pack();
	}

	public PackBuilder setFoo(int foo) {
		pack.setFoo(foo);
		return this;
	}

	public PackBuilder setBar(int bar) {
		pack.setBar(bar);
		return this;
	}

	public PackBuilder setQix(int qix) {
		pack.setQix(qix);
		return this;
	}

	public PackBuilder setBaz(int baz) {
		pack.setBaz(baz);
		return this;
	}

	public PackBuilder addPack() {
		return scalaskelMoneyBuilder.addPack();
	}

	public ScalaskelMoney build() {
		return scalaskelMoneyBuilder.build();
	}

	Pack buildPack() {
		return pack;
	}

}
