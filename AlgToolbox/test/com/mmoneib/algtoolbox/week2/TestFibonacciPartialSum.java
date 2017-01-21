package com.mmoneib.algtoolbox.week2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mmoneib.algtoolbox.AbstractTest;

public class TestFibonacciPartialSum extends AbstractTest {

	@Test
	public void testGetFibonacciPartialSumNaive() {
		try {
			assertEquals(1, FibonacciPartialSum.getFibonacciPartialSumNaive(3L, 7L));
			assertEquals(5, FibonacciPartialSum.getFibonacciPartialSumNaive(10L, 10L));
			assertEquals(2, FibonacciPartialSum.getFibonacciPartialSumNaive(10L, 200L));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

	@Test
	public void testGetFibonacciPartialSumFast() {
		try {
			assertEquals(1, FibonacciPartialSum.getFibonacciPartialSumFast(3L, 7L));
			assertEquals(5, FibonacciPartialSum.getFibonacciPartialSumFast(10L, 10L));
			assertEquals(2, FibonacciPartialSum.getFibonacciPartialSumFast(10L, 200L));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

}
