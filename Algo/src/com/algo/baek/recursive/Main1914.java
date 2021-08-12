package com.algo.baek.recursive;

import java.math.BigInteger;
import java.util.Scanner;

public class Main1914 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		BigInteger ans = new BigInteger("2");
		ans = ans.pow(N).subtract(new BigInteger("1")); // 하노이 탑 2^n-1

		System.out.println(ans);
		if(N > 20) return;
		hanoi(N, 1, 2, 3);
		System.out.println(sb);

	}
	static void hanoi(int n, int s, int t, int d){
		if(n==1){
			sb.append(s+" "+d+"\n");
			return;
		}

		// n-1개를 목적기둥
		hanoi(n-1, s, d, t);
		sb.append(s+" "+d+"\n");
		hanoi(n-1,t,s,d);
	}
}
