package com.mmoneib.algtoolbox.week1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class TestMaxPairwiseProduct {

	@Test
	public void stressTest() {
		int maxArraySize = 101;
		int maxValue = 1000001;
		int numberOfTries = 100000;
		int tryCount = 0;

		try {
			while (tryCount < numberOfTries) {
				// Generate random array.
				Random randomizer = new Random();
				int n = randomizer.nextInt(maxArraySize);
				int[] randArr = new int[n];
				for (int i = 0; i < n; i++) {
					randArr[i] = randomizer.nextInt(maxValue);
				}

				for (int i : randArr) {
					System.out.print(i + " ");
				}
				System.out.println();

				long result1 = MaxPairwiseProduct.getMaxPairwiseProduct(randArr);
				long result2 = MaxPairwiseProduct.getFastMaxPairwiseProduct(randArr);

				System.out.println("Naive=" + result1 + " | " + "Efficient=" + result2);
				// Comparing outcome of 2 independent solutions to catch
				// discrepancies.
				assertTrue(result1 == result2);

				tryCount++;
			}
		} catch (Exception exception) {
			fail(exception.getMessage());
		}
	}

}
