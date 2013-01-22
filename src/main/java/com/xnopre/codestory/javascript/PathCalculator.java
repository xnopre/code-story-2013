package com.xnopre.codestory.javascript;

import static com.xnopre.codestory.javascript.JajaVol.State.ADDED;
import static com.xnopre.codestory.javascript.JajaVol.State.AVAILABLE;
import static com.xnopre.codestory.javascript.JajaVol.State.UNADDABLE;

import java.util.ArrayList;
import java.util.List;

public class PathCalculator {

	public JajaPath calculate(JajaRequest javaRequest) {
		JajaVol[] vols = javaRequest.getVolsArray();
		TempPath tempPath = new TempPath();
		TempPath bestTempPath = process(tempPath, vols);
		return convertToJajaPath(bestTempPath);
	}

	private TempPath process(TempPath tempPath, JajaVol[] vols) {
		TempPath bestTempPath = new TempPath(tempPath);
		for (int i = 0; i < vols.length; i++) {
			JajaVol vol = vols[i];
			if (vol.state == AVAILABLE) {
				TempPath newTempPath;
				if (isAddable(tempPath, vol)) {
					vol.state = ADDED;
					tempPath.add(vol);
					newTempPath = process(tempPath, vols);
					tempPath.remove(vol);
					vol.state = AVAILABLE;
				} else {
					vol.state = UNADDABLE;
					newTempPath = process(tempPath, vols);
					vol.state = AVAILABLE;
				}
				bestTempPath = bestOf(bestTempPath, newTempPath);
			}
		}
		return bestTempPath;
	}

	private TempPath bestOf(TempPath jajaPath1, TempPath jajaPath2) {
		return jajaPath1.getGain() >= jajaPath2.getGain() ? jajaPath1 : jajaPath2;
	}

	private boolean isAddable(TempPath tempPath, JajaVol vol) {
		JajaVol[] vols = tempPath.getVolsArray();
		int depart = vol.getDepart();
		int arrivee = depart + vol.getDuree();
		for (int i = 0; i < vols.length; i++) {
			int depart_i = vols[i].getDepart();
			int arrivee_i = depart_i + vols[i].getDuree();
			boolean addable = arrivee <= depart_i || depart >= arrivee_i;
			if (!addable) {
				return false;
			}
		}
		return true;
	}

	private JajaPath convertToJajaPath(TempPath bestTempPath) {
		return new JajaPath(bestTempPath.getGain(), getVolsNames(bestTempPath.getVols()));
	}

	private List<String> getVolsNames(List<JajaVol> vols) {
		List<String> volsNames = new ArrayList<String>();
		for (JajaVol vol : vols) {
			volsNames.add(vol.getName());
		}
		return volsNames;
	}
}
