package com.mmoneib.algtoolbox.week2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mmoneib.algtoolbox.AbstractTest;

public class TestGCD extends AbstractTest{

	@Test
	public void testGCDNaive() {
		try {
			assertEquals(1, GCD.lcm_naive(18, 35));
			assertEquals(17657, GCD.lcm_naive(28851538, 1183019));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}
	
	@Test
	public void testGCDFast() {
		try {
			assertEquals(1, GCD.gcdFast(18, 35));
			assertEquals(17657, GCD.gcdFast(28851538, 1183019));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}
	
	@Test
	public void testGCDFast_max() {
		try {
			assertEquals(2000000000, GCD.gcdFast(2000000000, 2000000000));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}
}
