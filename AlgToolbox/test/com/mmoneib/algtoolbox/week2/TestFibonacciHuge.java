package com.mmoneib.algtoolbox.week2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFibonacciHuge {

	@Test
	public void testGetFibonacciHugeNaive() {
		try {
			assertEquals(1, FibonacciHuge.getFibonacciHugeNaive(1, 239));
			assertEquals(161, FibonacciHuge.getFibonacciHugeNaive(239, 1000));
			assertEquals(10249, FibonacciHuge.getFibonacciHugeNaive(2816213588L, 30524));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

	@Test
	public void testGetFibonacciHugeFast() {
		try {
			//assertEquals(0, FibonacciHuge.getFibonacciHugeFast(8, 3));

			assertEquals(1, FibonacciHuge.getFibonacciHugeFast(1, 239));
			//assertEquals(161, FibonacciHuge.getFibonacciHugeFast(239, 1000));
			//assertEquals(10249, FibonacciHuge.getFibonacciHugeFast(2816213588L, 30524));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}
}
