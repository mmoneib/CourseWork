package com.mmoneib.algtoolbox.week3;

import java.util.*;

public class DotProduct {
	protected static long maxDotProduct(int[] a, int[] b) {
		int tempHighestIndexA = 0;
		int tempHighestIndexB = 0;
		int tempA = -1;
		int tempB = -1;

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[tempHighestIndexA]) {
					tempHighestIndexA = j;
				}
				if (b[j] > b[tempHighestIndexB]) {
					tempHighestIndexB = j;
				}
			}
			tempA = a[i];
			a[i] = a[tempHighestIndexA];
			a[tempHighestIndexA] = tempA;

			tempB = b[i];
			b[i] = b[tempHighestIndexB];
			b[tempHighestIndexB] = tempB;
			
			tempHighestIndexA=i+1;
			tempHighestIndexB=i+1;
		}

		long result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i] * b[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = scanner.nextInt();
		}
		System.out.println(maxDotProduct(a, b));
	}
}
