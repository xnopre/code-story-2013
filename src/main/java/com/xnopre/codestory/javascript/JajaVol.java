package com.xnopre.codestory.javascript;

import static com.xnopre.codestory.javascript.JajaVol.State.AVAILABLE;

public class JajaVol {

	enum State {
		AVAILABLE, ADDED, UNADDABLE
	};

	private final String name;
	private final int depart;
	private final int duree;
	private final int prix;

	State state = AVAILABLE;

	public JajaVol(String name, int depart, int duree, int prix) {
		this.name = name;
		this.depart = depart;
		this.duree = duree;
		this.prix = prix;
	}

	public String getName() {
		return name;
	}

	public int getDepart() {
		return depart;
	}

	public int getDuree() {
		return duree;
	}

	public int getPrix() {
		return prix;
	}

}
