package com.mmoneib.algtoolbox.week2;

import java.util.*;

public class FibonacciLastDigit {
	//Returns wrong answer for large values.
	//This swapping implementation uses less memory.
	protected static int getFibonacciLastDigitNaive(int n) {
		if (n <= 1)
			return n;

		int previous = 0;
		int current = 1;

		/*
		 * Such swapping implementation needs to start from zero index as it is
		 * some sort of simulation.
		 */
		for (int i = 0; i < n - 1; ++i) {
			int tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
			//The current will usually be one step in advance.
		}

		return current % 10;
	}

	protected static int getFibonacciLastDigitFast(int index) {
		int size = index + 1;
		if (index <= 1) {
			size = 2;
		}
		int[] fibArr = new int[size];
		  
		  fibArr[0]=0;
		  fibArr[1]=1;
		  
		  for(int i=2;i<=index;i++){
			  fibArr[i]=(fibArr[i-1]%10+fibArr[i-2]%10)%10;
		  }
		  
		  return fibArr[index];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int c = getFibonacciLastDigitFast(n);
		System.out.println(c);
	}
}
