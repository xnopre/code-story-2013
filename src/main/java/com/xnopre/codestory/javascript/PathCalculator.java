package com.xnopre.codestory.javascript;

import static com.xnopre.codestory.javascript.JajaVol.State.ADDED;
import static com.xnopre.codestory.javascript.JajaVol.State.AVAILABLE;
import static com.xnopre.codestory.javascript.JajaVol.State.UNADDABLE;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PathCalculator {

	private static final Logger logger = LoggerFactory.getLogger(PathCalculator.class);

	public JajaPath calculate(JajaRequest javaRequest) {
		List<JajaVol> vols = javaRequest.getVols();
		TempPath tempPath = new TempPath();
		logger.info("start process ...");
		long time0 = System.currentTimeMillis();
		TempPath bestTempPath = process(tempPath, vols, 0);
		logger.info("process ended in " + (System.currentTimeMillis() - time0) + " ms");
		return convertToJajaPath(bestTempPath);
	}

	private TempPath process(TempPath tempPath, List<JajaVol> vols, int startIndex) {
		TempPath bestTempPath = new TempPath(tempPath);
		for (int i = startIndex; i < vols.size(); i++) {
			JajaVol vol = vols.get(i);
			if (vol.state == AVAILABLE) {
				TempPath newTempPath;
				if (isAddable(tempPath, vol)) {
					tempPath.add(vol);
					vol.state = ADDED;
					newTempPath = process(tempPath, vols, i + 1);
					tempPath.remove(vol);
					vol.state = AVAILABLE;
				} else {
					vol.state = UNADDABLE;
					newTempPath = process(tempPath, vols, i + 1);
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
