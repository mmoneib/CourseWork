package com.mmoneib.algtoolbox.week2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mmoneib.algtoolbox.AbstractTest;

public class TestFibonacciLastDigit extends AbstractTest {

	@Test
	public void testGetFibonacciLastDigitNaive() {
		try {
			assertEquals(9, FibonacciLastDigit.getFibonacciLastDigitNaive(331));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}
	
	@Test
	public void testGetFibonacciLastDigitFast() {
		try {
			assertEquals(5, FibonacciLastDigit.getFibonacciLastDigitFast(327305));
			assertEquals(1, FibonacciLastDigit.getFibonacciLastDigitFast(239));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}
	
	@Test
	public void testGetFibonacciLastDigitFast_max() {
		try {
			assertEquals(9, FibonacciLastDigit.getFibonacciLastDigitFast(10000000));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

}
