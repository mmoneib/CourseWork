package com.mmoneib.algtoolbox.week2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLCM {

	@Test
	public void testLcm_naive() {
		try {
			assertEquals(24, LCM.lcm_naive(6, 8));
			assertEquals(1933053046, LCM.lcm_naive(28851538, 1183019));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

	@Test
	public void testLcmFast() {
		try {
			assertEquals(24, LCM.lcmFast(6, 8));
			assertEquals(1933053046, LCM.lcmFast(28851538, 1183019));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

	@Test
	public void testLcmFast_max() {
		try {
			assertEquals(2000000000, LCM.lcmFast(2000000000, 2000000000));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error: " + e.getMessage());
		}
	}

}
