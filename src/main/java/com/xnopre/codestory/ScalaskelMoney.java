package com.xnopre.codestory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScalaskelMoney {

	private final List<Pack> packs = new ArrayList<Pack>();

	public int packCount() {
		return packs.size();
	}

	public Pack getPack(int index) {
		return packs.get(index);
	}

	public void addPack(Pack pack) {
		packs.add(pack);
	}

	public List<Map<String, Integer>> asListOfMap() {
		List<Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();
		for (Pack pack : packs) {
			listOfMaps.add(pack.asMap());
		}
		return listOfMaps;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScalaskelMoney other = (ScalaskelMoney) obj;
		if (packs == null) {
			if (other.packs != null)
				return false;
		} else if (!packs.equals(other.packs))
			return false;
		return true;
	}

}
