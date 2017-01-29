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

		/*
		 * Filling should be from items with high unit value to those with low
		 * ones. Therefore, we must calculate the unit values of all items to
		 * begin with.
		 */
		for (int i = 0; i < values.length; i++) {
			unitValues[i] = values[i] * 1.0 / weights[i] * 1.0;
		}

		/*
		 * The greediness of the algorithm is due to the facty that we try to
		 * insert the item with the highest unit value (value of 1kg) first in
		 * the knapsack. The item is then removed from the list of available
		 * items and the problem is reduced subsequently for the next iteration.
		 * The insertion is a safe move because the most valuable collection
		 * will always contain the item with the highest unit value.
		 */
		while (capacity > 0) {
			int largestIndex = 0;
			double tempUnitValue = -1.0;
			/*
			 * As a way of optimization, all items should be sorted in
			 * descending order of their unit values, which will render the
			 * following loop unneeded, reducing the time complexity of the
			 * whole algorithm from Big-O(n^2) to Big-O(n).
			 */
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
				/*
				 * Only the last item in the sack will be partitioned, if
				 * eneded.
				 */
				capacity = 0;
			}

			/*
			 * Invalidating the current item's unit value to prevent it from
			 * being selected again.
			 */
			unitValues[largestIndex] = -1;
		}

		// return Double.valueOf(new DecimalFormat("#.####").format(value));
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
