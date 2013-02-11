package com.xnopre.codestory.javascript;

import java.util.ArrayList;
import java.util.List;

class TempPath {

	private final List<JajaVol> vols = new ArrayList<JajaVol>();
	private int gain = 0;
	private long maskOccupations = 0L;

	public TempPath() {
	}

	public TempPath(TempPath tempPath) {
		vols.addAll(tempPath.vols);
		gain = tempPath.gain;
	}

	public void add(JajaVol vol) {
		vols.add(vol);
		gain += vol.prix;
		maskOccupations |= getMask(vol);
	}

	public void remove(JajaVol vol) {
		vols.remove(vol);
		gain -= vol.prix;
		maskOccupations &= ~getMask(vol);
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

	public boolean isAddable(JajaVol vol) {
		return (maskOccupations & getMask(vol)) == 0;
	}

	private long getMask(JajaVol vol) {
		long mask = 0;
		for (int i = vol.depart; i <= vol.depart + vol.duree; i++) {
			mask |= 1 << i;
		}
		return mask;
	}
}
