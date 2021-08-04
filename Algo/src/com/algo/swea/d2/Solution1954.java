package com.algo.swea.d2;

import java.util.Scanner;

public class Solution1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t=1; t<=T; t++){

			int N = sc.nextInt();
			int [][] arr= new int[N][N];
			int r = 0, c = -1;
			int cnt= 1;	// 1 2 3 4 ...
			int turn = 1;

			// 우 N 하 N-1 좌 N-1 상 N-2
			while(true){
				// 행이 변함
				for(int i=0; i<N; i++){
					c += turn;
					arr[r][c] = cnt++;
				}
				N--;
				// 열이 변함
				for(int i=0; i<N; i++){
					r += turn;
					arr[r][c] = cnt++;
				}
				turn *= -1; // 증가 -> 감소

				if(N==0)
					break;
			}

			System.out.println("#"+t);

			for (int i=0; i<arr.length; i++){
				for(int j=0; j<arr.length; j++){
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
