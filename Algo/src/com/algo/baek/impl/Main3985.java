package com.algo.baek.impl;

import java.util.Scanner;

// 롤케이크
public class Main3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();

		int[] cake = new int[L+1];

		int ans1 = 0;
		int ans2 = 0;
		int tmp1 = 0;
		int tmp2 = 0;

		for(int i=1; i<=N; i++){
			int p = sc.nextInt();
			int k = sc.nextInt();
			int cnt = 0;


			for(int j=p; j<=k; j++){
				if(cake[j]==0){
					cake[j] = i;
					cnt++;
				}
			}

			if(k-p>tmp1){
				tmp1 = k-p;
				ans1 = i;
			}
			if(cnt>tmp2){
				tmp2 = cnt;
				ans2 = i;
			}
		}

		System.out.println(ans1);
		System.out.println(ans2);

	}
}
