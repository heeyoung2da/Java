package com.algo.baek.dp;

import java.util.Scanner;

/*
RGB거리
 */
public class Main1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] D = new int[N+1][3];

		for(int i=1; i<=N; i++){
			int R = sc.nextInt();
			int G = sc.nextInt();
			int B = sc.nextInt();

			D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + R;
			D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + G;
			D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + B;
		}
		System.out.println(Math.min(D[N][0], Math.min(D[N][1], D[N][2])));
	}
}
