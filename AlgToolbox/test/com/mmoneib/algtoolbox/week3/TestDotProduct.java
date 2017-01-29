package com.mmoneib.algtoolbox.week3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mmoneib.algtoolbox.AbstractTest;

public class TestDotProduct extends AbstractTest {

	@Test
	public void testMaxDotProduct() {
		try {
			int a1[] = { 23 };
			int b1[] = { 39 };
			assertEquals(897, DotProduct.maxDotProduct(a1, b1));

			int a2[] = { 1, 3, -5 };
			int b2[] = { -2, 4, 1 };
			assertEquals(23, DotProduct.maxDotProduct(a2, b2));
		} catch (Exception exception) {
			exception.printStackTrace();
			fail("Error: " + exception.getMessage());
		}
	}

}
