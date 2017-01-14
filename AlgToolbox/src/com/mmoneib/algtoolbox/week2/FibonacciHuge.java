package com.mmoneib.algtoolbox.week2;

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
		return pisano.get((int) (n%getPisanoPeriod(m)));
	}

	private static void fib(long index, ArrayList<Long> pisano) {
		long[] fibArr = new long[(int) (100 + 1)];
		fibArr[0] = 0;
		fibArr[1] = 1;
		
		pisano.add(0L);
		pisano.add(1L);

		for (int i = 2; i < 101; i++) {
			fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
//			System.out.println(fibArr[i]+"/"+(long) (fibArr[i]%(int)index));

			pisano.add((long) (fibArr[i]%(int)index));
		}

		//return fibArr[(int) index];
	}

	private static int getPisanoPeriod(long m) {
		fib(m,pisano);
		int maxPeriod=0;
		int tmpPeriod=0;
		for(int i=0,j=2,iMax=j;j<pisano.size()&&i<=iMax;){
System.out.println(pisano.get(i)+"|"+pisano.get(j));
			if(pisano.get(i)==pisano.get(j)){
				i++;
				j++;
				tmpPeriod++;
			}else{
				i=0;
				maxPeriod=tmpPeriod;
				tmpPeriod=0;
				iMax=j++;
			}
			maxPeriod=tmpPeriod;
		}
		System.out.println("Max="+maxPeriod);
		return maxPeriod;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		System.out.println(getFibonacciHugeFast(n, m));
	}
}
