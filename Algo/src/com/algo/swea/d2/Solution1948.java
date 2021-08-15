package com.algo.swea.d2;

import java.util.Scanner;

// 날짜 계산기
public class Solution1948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] day = {0,31,28,31,30,31,30,31,31,30,31,30,31};

		for(int t=1; t<=T; t++){
			int[] input = new int[4];
			int ans = 0;

			for(int i=0; i<4; i++){
				input[i] = sc.nextInt();
			}

			if(input[0]<input[2]){
				ans += day[input[0]] - input[1];
				for(int i = input[0]+1; i< input[2]; i++){
					ans += day[i];
				}
				ans += input[3]+1;
			}else{
				ans = input[3]-input[1]+1;
			}

			System.out.println("#"+t+" "+ans);
		}
	}
}
