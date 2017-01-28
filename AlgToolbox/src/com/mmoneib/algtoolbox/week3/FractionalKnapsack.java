package com.mmoneib.algtoolbox.week3;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Maximizing the Value of a Loot: A thief finds much more loot than his bag can
 * fit. Help him to find the most valuable combination of items assuming that
 * any fraction of a loot item can be put into his bag.
 * 
 * @author mmoneib
 *
 */
public class FractionalKnapsack {
	/**
	 * A greedy algorithm for the fractional knapsack problem. The desired goal
	 * is to get the combination of portions of the provided items with the
	 * maximum value compared to other combinations.
	 * 
	 * @param capacity
	 *            Maximum weight allowed by the knapsack.
	 * @param values
	 *            An array holding the value of each item.
	 * @param weights
	 *            An array holding the weight of each item.
	 * @return The maximum value allowed to fit in the knapsack. The number
	 *         should be shown up to 4 digits after the decimal point.
	 */
	protected static double getOptimalValue(int capacity, int[] values, int[] weights) {
		double value = 0;
		double[] unitValues = new double[values.length];

		for (int i = 0; i < values.length; i++) {
			unitValues[i] = values[i] * 1.0 / weights[i] * 1.0;
		}

		while (capacity > 0) {
			int largestIndex = 0;
			double tempUnitValue = -1.0;
			for (int i = 0; i < unitValues.length; i++) {
				if (unitValues[i] > tempUnitValue) {
					largestIndex = i;
					tempUnitValue = unitValues[i];
				}
			}

			if (capacity >= weights[largestIndex]) {
				capacity -= weights[largestIndex];
				value += values[largestIndex];
			} else {
				value += capacity * unitValues[largestIndex];
				capacity = 0;
			}

			unitValues[largestIndex] = -1;
		}

		//return Double.valueOf(new DecimalFormat("#.####").format(value));
		return value;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		System.out.println(getOptimalValue(capacity, values, weights));
	}
}
