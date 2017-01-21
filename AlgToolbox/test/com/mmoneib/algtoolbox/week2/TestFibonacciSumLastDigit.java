package com.mmoneib.algtoolbox.week2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mmoneib.algtoolbox.AbstractTest;

public class TestFibonacciSumLastDigit extends AbstractTest {

	@Test
	public void testGetFibonacciSumNaive() {
		try {
			assertEquals(4, FibonacciSumLastDigit.getFibonacciSumNaive(3));
			assertEquals(5, FibonacciSumLastDigit.getFibonacciSumNaive(100));
			assertEquals(5, FibonacciSumLastDigit.getFibonacciSumNaive(100000000000000L));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

	@Test
	public void testGetFibonacciSumFast() {
		try {
			assertEquals(4, FibonacciSumLastDigit.getFibonacciSumFast(3));
			assertEquals(5, FibonacciSumLastDigit.getFibonacciSumFast(100));
			assertEquals(5, FibonacciSumLastDigit.getFibonacciSumFast(100000000000000L));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

}