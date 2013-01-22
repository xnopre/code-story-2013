package com.xnopre.codestory.javascript;

import java.util.ArrayList;
import java.util.List;

public class JajaRequest {

	private final List<JajaVol> vols = new ArrayList<JajaVol>();

	public int getVolsCount() {
		return vols.size();
	}

	public JajaVol getVol(int index) {
		return vols.get(index);
	}

	public void addVol(JajaVol vol) {
		vols.add(vol);
	}

	public JajaVol[] getVolsArray() {
		return vols.toArray(new JajaVol[vols.size()]);
	}

	public List<JajaVol> getVols() {
		return vols;
	}

}
