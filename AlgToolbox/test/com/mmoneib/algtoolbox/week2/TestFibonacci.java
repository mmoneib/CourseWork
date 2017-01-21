package com.mmoneib.algtoolbox.week2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.mmoneib.algtoolbox.AbstractTest;

public class TestFibonacci extends AbstractTest{

	@Test
	public void test_calc_fib() {
		try {
			assertEquals(1134903170, Fibonacci.calc_fib(45));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

	@Test
	public void testCalcFibFast() {
		try {
			assertEquals(2, Fibonacci.calcFibFast(3));
			assertEquals(0, Fibonacci.calcFibFast(0));
			assertEquals(1134903170, Fibonacci.calcFibFast(45));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

}
