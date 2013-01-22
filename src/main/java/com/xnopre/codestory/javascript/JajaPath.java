package com.xnopre.codestory.javascript;

import java.util.List;

public class JajaPath {

	private final int gain;
	private final List<String> volsNames;

	public JajaPath(int gain, List<String> volsNames) {
		this.gain = gain;
		this.volsNames = volsNames;
	}

	public int getGain() {
		return gain;
	}

	public List<String> getVolsNames() {
		return volsNames;
	}

}
