package com.mmoneib.algtoolbox.week2;

import java.util.Scanner;

public class Fibonacci {
	protected static long calc_fib(int n) {
		if (n <= 1)
			return n;

		return calc_fib(n - 1) + calc_fib(n - 2);
	}

	protected static long calcFibFast(int index) {
		int size = index + 1;
		if (index <= 1) {
			size = 2;
		}
		long[] fibArr = new long[size];

		fibArr[0] = 0;
		fibArr[1] = 1;

		for (int i = 2; i <= index; i++) {
			fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
		}

		return fibArr[index];
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		System.out.println(calcFibFast(n));
	}
}
