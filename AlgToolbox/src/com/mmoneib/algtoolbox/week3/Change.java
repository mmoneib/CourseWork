package com.mmoneib.algtoolbox.week3;

import java.util.Scanner;

/**
 * Changing Money: The goal in this problem is to find the minimum number of
 * coins needed to change the input value (an integer) into coins with
 * denominations 1, 5, and 10.
 * 
 * @author mmoneib
 *
 */
public class Change {

	/**
	 * An elementary greedy algorithm used by cashiers all over the world
	 * millions of times per day.
	 * 
	 * @param m
	 *            Value of money to be changed.
	 * @return Number of change coins.
	 */
	protected static int getChange(int m) {
		int coinsCount = 0;

		/*
		 * Here, I used three separate loops instead of a single one to avoid
		 * using an array of possible coin values. The algorithm is greedy in
		 * the way it tries to fit the largest values first, similar to the
		 * knapsack problem, so as to finish the problem quicker. The firs move
		 * is safa (optimal solution guaranteed), as the largest remaining coin
		 * that could fit will always be used, reducing the problem for the next
		 * iteration, both in terms of the remaining value and the remaining
		 * coins.
		 * 
		 * Time Complexity: Big-O(n) It will usually be less than that, as m
		 * reduces by 10s and 5s.
		 */

		while (m - 10 >= 0) {
			coinsCount++;
			m -= 10;
		}

		while (m - 5 >= 0) {
			coinsCount++;
			m -= 5;
		}

		while (m - 1 >= 0) {
			coinsCount++;
			m -= 1;
		}

		return coinsCount;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(getChange(m));

	}
}
