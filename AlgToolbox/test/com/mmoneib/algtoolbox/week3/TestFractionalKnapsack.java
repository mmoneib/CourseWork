package com.mmoneib.algtoolbox.week3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mmoneib.algtoolbox.AbstractTest;

public class TestFractionalKnapsack extends AbstractTest {

	@Test
	public void testGetOptimalValue() {
		try {
			int[] values = { 60, 100, 120 };
			int[] weights = { 20, 50, 30 };
			assertEquals(180.000, FractionalKnapsack.getOptimalValue(50, values, weights), 0.001);
			int[] values2 = { 500 };
			int[] weights2 = { 30 };
			assertEquals(166.6667, FractionalKnapsack.getOptimalValue(10, values2, weights2), 0.001);
		} catch (Exception exception) {
			exception.printStackTrace();
			fail("Error: " + exception.getMessage());
		}
	}

}
