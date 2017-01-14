package com.mmoneib.algtoolbox.week2;

import java.util.Scanner;

public class LCM {
	protected static long lcm_naive(int a, int b) {
		for (long l = 1; l <= (long) a * b; ++l)
			if (l % a == 0 && l % b == 0)
				return l;

		return (long) a * b;
	}

	protected static long lcmFast(int a, int b) {
		/*
		 * LCM = (a*b)/Constant Constant --> GCD
		 */
		return a * (long)b / gcdFast(a, b);
	}

	private static long gcdFast(long a, long b) {
		if (a % b == 0) {
			return b;
		}
		return gcdFast(b, a % b);
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		System.out.println(lcmFast(a, b));
	}
}
