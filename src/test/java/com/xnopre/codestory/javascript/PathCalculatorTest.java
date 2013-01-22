package com.xnopre.codestory.javascript;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class PathCalculatorTest {

	@Test
	public void test() {
		JajaRequest jajaRequest = new JajaRequest();
		jajaRequest.addVol(new JajaVol("MONAD42", 0, 5, 10));
		jajaRequest.addVol(new JajaVol("META18", 3, 7, 14));
		jajaRequest.addVol(new JajaVol("LEGACY01", 5, 9, 8));
		jajaRequest.addVol(new JajaVol("YAGNI17", 5, 9, 7));

		JajaPath path = new PathCalculator().calculate(jajaRequest);

		assertEquals(18, path.getGain());
		List<String> names = path.getVolsNames();
		String[] namesArray = names.toArray(new String[0]);
		String[] expected = { "MONAD42", "LEGACY01" };
		assertArrayEquals(expected, namesArray);

	}
}
