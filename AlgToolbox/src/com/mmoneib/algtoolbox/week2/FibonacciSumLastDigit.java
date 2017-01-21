package com.mmoneib.algtoolbox.week2;

import java.util.*;

public class FibonacciSumLastDigit {
	private static ArrayList<Long> pisano = new ArrayList<>();

	protected static long getFibonacciSumNaive(long n) {
		if (n <= 1)
			return n;

		long previous = 0;
		long current = 1;
		long sum = 1;

		/*
		 * Embedding the sum inside Fibonnaci's loop. Since Fibonnaci's numbers
		 * are counted in their whole, this is not suitable for huge numbers.
		 */
		for (long i = 0; i < n - 1; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
			sum += current;
		}

		return sum % 10;
	}

	protected static int getFibonacciSumFast(long n) {
		int beforePrevious = 0;
		int previous = 1;
		ArrayList<Integer> sumList=new ArrayList<>();
		int pisanoSize=getPisanoPeriodFaster(10L);
		sumList.add(0);
		sumList.add(1);

		if (n == 0) {
			return beforePrevious;
		}
		if (n == 1) {
			return previous;
		}

		for (int i = 2; i < pisanoSize; i++) {
			sumList.add((sumList.get(i-1)+sumList.get(i-2)+1)%10);
		}

		return sumList.get((int)(n%(long)sumList.size()));
	}

	private static int getPisanoPeriodFaster(long m) {
		long beforePrevious = 0;
		long previous = 1;
		long current = (beforePrevious + previous) % m;
		pisano.clear();
		pisano.add(beforePrevious);
		pisano.add(previous);
		pisano.add(current);

		do {
			beforePrevious = previous;
			previous = current;
			current = (beforePrevious + previous) % m;
			pisano.add(current);
		} while (!(beforePrevious == 0 && previous == 1));
		// System.out.println(pisano.size()-3);
		return pisano.size() - 3;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long s = getFibonacciSumFast(n);
		System.out.println(s);
	}
}
