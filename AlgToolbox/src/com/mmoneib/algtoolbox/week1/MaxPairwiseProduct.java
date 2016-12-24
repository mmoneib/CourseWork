package com.mmoneib.algtoolbox.week1;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
	static long getMaxPairwiseProduct(int[] numbers) {
		// Dumb solution with running time = theta(n^2).
		long result = 0;
		int n = numbers.length;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (numbers[i] * (long) numbers[j] > result) {
					System.out.println("I=" + i + " " + "J=" + j);
					// At least one operand should be cast to "long", otherwise,
					// the result would be cast from int to long causing errors.
					result = (long) numbers[i] * numbers[j];
				}
			}
		}
		return result;
	}

	static long getFastMaxPairwiseProduct(int[] numbers) {
		int[] numArr = { 0, 0 };

		for (int n : numbers) {
			if (n > numArr[0]) {
				numArr[1] = Math.max(numArr[0], numArr[1]);
				numArr[0] = n;
			} else {
				numArr[1] = Math.max(n, numArr[1]);
			}
		}
		// Returning long to avoid integer overflow when having max pairs
		// 10000*90000. which is more than maximum int.
		return (long) numArr[0] * numArr[1];
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		System.out.println(getFastMaxPairwiseProduct(numbers));
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st; // to remove spaces.

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					// Each space in input is treated as new line, hence
					// readline().
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}