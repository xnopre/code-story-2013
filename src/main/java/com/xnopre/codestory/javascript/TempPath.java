package com.xnopre.codestory.javascript;

import java.util.ArrayList;
import java.util.List;

class TempPath {

	private final List<JajaVol> vols = new ArrayList<JajaVol>();
	private int gain = 0;

	public TempPath() {
	}

	public TempPath(TempPath tempPath) {
		vols.addAll(tempPath.vols);
		gain = tempPath.gain;
	}

	public void add(JajaVol vol) {
		vols.add(vol);
		gain += vol.getPrix();
	}

	public void remove(JajaVol vol) {
		vols.remove(vol);
		gain -= vol.getPrix();
	}

	public List<JajaVol> getVols() {
		return vols;
	}

	public JajaVol[] getVolsArray() {
		return vols.toArray(new JajaVol[vols.size()]);
	}

	public int getGain() {
		return gain;
	}

}
