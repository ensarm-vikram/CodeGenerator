package com.generator;

import org.junit.Assert;
import org.junit.Test;

public class CodeGeneratorTest {

	@Test
	public void testGenerate() {
		CodeGenerator gen = new CodeGenerator();
		boolean isSucces = gen.generate();
		Assert.assertTrue(isSucces);
	}
}
