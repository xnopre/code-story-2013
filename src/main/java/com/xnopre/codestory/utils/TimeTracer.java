package com.xnopre.codestory.utils;

import org.slf4j.Logger;

import com.xnopre.codestory.CodestoryException;

public class TimeTracer {

	private long time0 = 0;
	private final Logger logger;

	public TimeTracer(Logger logger) {
		this.logger = logger;
	}

	public void init() {
		time0 = MySystem.currentTimeMillis();
	}

	public void log(String message) {
		if (time0 == 0) {
			throw new CodestoryException("'init' method must be called before 'lo'");
		}
		long deltaTime = MySystem.currentTimeMillis() - time0;
		logger.info("+" + deltaTime + " : " + message);
	}

}
