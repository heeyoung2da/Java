package com.algo.swea.d3;

import java.util.Scanner;

// 부먹왕국의 차원 관문
public class Solution7964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++){
			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] arr = new int[N];

			for(int i=0; i<N; i++){
				arr[i] = sc.nextInt();
			}
			int cnt = arr[0] == 0 ? 1:0;
			int tmp = D;
			for(int i=1; i<N; i++){
				if(arr[i]==1){
					tmp = D;
				}else{
					tmp--;
					if(tmp==0){
						tmp = D;
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
