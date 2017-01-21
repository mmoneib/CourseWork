package com.mmoneib.algtoolbox.week2;

import java.util.*;

public class FibonacciPartialSum {
	private static ArrayList<Long> pisano = new ArrayList<>();

	protected static long getFibonacciPartialSumNaive(long from, long to) {
		if (to <= 1)
			return to;

		long previous = 0;
		long current = 1;

		for (long i = 0; i < from - 1; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
		}

		long sum = current;

		for (long i = 0; i < to - from; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
			sum += current;
		}

		return sum % 10;
	}

	protected static long getFibonacciPartialSumFast(long from, long to) {
		ArrayList<Integer> sumList = new ArrayList<>();
		int pisanoSize = getPisanoPeriodFaster(10L);
		sumList.add(0);
		sumList.add(1);

		for (int i = 2; i < pisanoSize; i++) {
			sumList.add((sumList.get(i - 1) + sumList.get(i - 2) + 1) % 10);
		}

		return ((sumList.get((int) (to % (long) sumList.size()))
				- sumList.get((int) ((from - 1) % (long) sumList.size())))+10) % 10;
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
		long from = scanner.nextLong();
		long to = scanner.nextLong();
		System.out.println(getFibonacciPartialSumFast(from, to));
	}
}
