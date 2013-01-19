package com.xnopre.codestory;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pack {

	private int foo;
	private int bar;
	private int qix;
	private int baz;

	public int getFoo() {
		return foo;
	}

	public void setFoo(int foo) {
		this.foo = foo;
	}

	public int getBar() {
		return bar;
	}

	public void setBar(int bar) {
		this.bar = bar;
	}

	public int getQix() {
		return qix;
	}

	public void setQix(int qix) {
		this.qix = qix;
	}

	public int getBaz() {
		return baz;
	}

	public void setBaz(int baz) {
		this.baz = baz;
	}

	public Map<String, Integer> asMap() {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		if (foo > 0) {
			map.put("foo", foo);
		}
		if (bar > 0) {
			map.put("bar", bar);
		}
		if (qix > 0) {
			map.put("qix", qix);
		}
		if (baz > 0) {
			map.put("baz", baz);
		}
		return map;
	}

	@Override
	public String toString() {
		return "Pack [foo=" + foo + ", bar=" + bar + ", qix=" + qix + ", baz=" + baz + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bar;
		result = prime * result + baz;
		result = prime * result + foo;
		result = prime * result + qix;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pack other = (Pack) obj;
		if (bar != other.bar)
			return false;
		if (baz != other.baz)
			return false;
		if (foo != other.foo)
			return false;
		if (qix != other.qix)
			return false;
		return true;
	}

}
