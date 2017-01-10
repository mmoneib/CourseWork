package com.mmoneib.algtoolbox.week2;

import java.util.*;

public class GCD {
	protected static int gcd_naive(int a, int b) {
		int current_gcd = 1;
		for (int d = 2; d <= a && d <= b; ++d) {
			if (a % d == 0 && b % d == 0) {
				if (d > current_gcd) {
					current_gcd = d;
				}
			}
		}

		return current_gcd;
	}

	protected static long gcdFast(long a, long b) {
		// The problem diminishes till mod equals zero. This happens when the
		// GCD is reached in the previous step, or when both parameters are 1
		// with mod equals zero when no other GCD is found.
		// Example: GCD(5,4) -> GCD(4,1) -> GCD(1,3) -> GCD(3,2) -> GCD(2,1) ->
		// GCD(1,1)
		if (a % b == 0) {
			return b; // The mod a%b of the previous step.
		}
		// Alternating params so as to reduce both sides, a and b along the way.
		return gcdFast(b, a % b);
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		System.out.println(gcdFast(a, b));
	}
}
