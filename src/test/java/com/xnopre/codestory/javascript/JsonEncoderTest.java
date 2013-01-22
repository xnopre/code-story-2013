package com.xnopre.codestory.javascript;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class JsonEncoderTest {

	@Test
	public void testEncode() {
		String[] volsNames = new String[] { "MONAD42", "LEGACY01" };
		JajaPath path = new JajaPath(18, Arrays.asList(volsNames));
		String json = new JsonEncoder().encode(path);

		Assert.assertEquals("{\"gain\":18,\"path\":[\"MONAD42\",\"LEGACY01\"]}", json);
	}

}
