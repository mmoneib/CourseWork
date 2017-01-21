package com.mmoneib.algtoolbox.week2;

import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
	private static ArrayList<Long> pisano = new ArrayList<>();

	protected static long getFibonacciHugeNaive(long n, long m) {
		if (n <= 1)
			return n;

		long previous = 0;
		long current = 1;

		for (long i = 0; i < n - 1; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
		}

		return current % m;
	}

	protected static long getFibonacciHugeFast(long n, long m) {
		// protected static long getFibonacciHugeFast(long n, long m) {
		// return pisano.get((int) (n % getPisanoPeriodModified(m)));
		//return pisano.get((int) (n % getPisanoPeriodModified(m))).longValue();
		return pisano.get((int) (n % getPisanoPeriodFaster(m)));
	}

	private static void fib(long index, ArrayList<Long> pisano) {
		long[] fibArr = new long[(int) (100 + 1)];
		fibArr[0] = 0;
		fibArr[1] = 1;

		pisano.add(0L);
		pisano.add(1L);

		for (int i = 2; i < 101; i++) {
			fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
			// System.out.println(fibArr[i]+"/"+(long) (fibArr[i]%(int)index));

			pisano.add((long) (fibArr[i] % (int) index));
		}

		// return fibArr[(int) index];
	}

	private static int getPisanoPeriod(long m) {
		// fib(m, pisano);
		int maxPeriod = 0;
		int tmpPeriod = 0;
		for (int i = 0, j = 2, iMax = j; j < pisano.size() && i <= iMax;) {
			System.out.println(pisano.get(i) + "|" + pisano.get(j));
			if (pisano.get(i) == pisano.get(j)) {
				i++;
				j++;
				tmpPeriod++;
			} else {
				i = 0;
				maxPeriod = tmpPeriod;
				tmpPeriod = 0;
				iMax = j++;
			}
			maxPeriod = tmpPeriod;
		}
		System.out.println("Max=" + maxPeriod);
		return maxPeriod;
	}

	private static int getPisanoPeriodModified(long m) {
		/*
		 * long beforePrevious = 0L; long previous = 1L; long current = 1L;
		 * pisano.add(0L); pisano.add(1L); pisano.add(1L);
		 * 
		 * do { beforePrevious = previous; previous = current; current =
		 * beforePrevious + previous; pisano.add(current % m); } while
		 * (!(current % m == 1 && previous % m == 0)); return pisano.size() - 2;
		 */
		/*BigInteger beforePrevious = new BigInteger("0");
		BigInteger previous = new BigInteger("1");
		BigInteger current = new BigInteger("1");
		pisano.clear();
		pisano.add(BigInteger.ZERO);
		pisano.add(BigInteger.ONE);
		pisano.add(BigInteger.ONE);

		do {
			beforePrevious = BigInteger.ZERO.add(previous);
			previous = BigInteger.ZERO.add(current);
			current = beforePrevious.add(previous);
			// System.out.println(current.toString());
			pisano.add(current.mod(BigInteger.valueOf(m)));
		} while (!(current.mod(BigInteger.valueOf(m)).equals(BigInteger.ONE)
				&& previous.mod(BigInteger.valueOf(m)).equals(BigInteger.ZERO)));
		// System.out.println(pisano.size()-2);
		return pisano.size() - 2;*/
		
		return 0;

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
		//System.out.println(pisano.size()-3);
		return pisano.size()-3;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		System.out.println(getFibonacciHugeFast(n, m));
	}
}
