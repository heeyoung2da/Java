package com.algo.swea.d2;

import java.util.Scanner;

// 파스칼의 삼각형
public class Solution2005 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			int[][] triangle = new int[N][N];

			for(int i=0; i<N; i++){
				for(int j=0; j<=i; j++){
					if(i==j){
						triangle[i][j] = 1;
					}
					else if(j==0){
						triangle[i][j] = 1;
					}
					else{
						triangle[i][j] = triangle[i-1][j-1]+triangle[i-1][j];
					}
				}
			}

			System.out.println("#"+t);
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(triangle[i][j]!=0){
						System.out.print(triangle[i][j]+" ");
					}
				}
				System.out.println();
			}

		}
	}
}
