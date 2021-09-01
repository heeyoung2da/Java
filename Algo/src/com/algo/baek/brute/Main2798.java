package com.algo.baek.brute;

import java.util.Scanner;

// 블랙잭
public class Main2798 {
	static int N,M;
	static int[] cards, tmp;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cards = new int[N];
		tmp = new int[3];

		for(int i=0; i<N; i++){
			cards[i] = sc.nextInt();
		}

		comb(0,0);
		System.out.println(max);
	}
	private static void comb(int cnt, int start){
		if(cnt==3){
//			System.out.println(Arrays.toString(tmp));
			int sum = 0;
			for(int i=0; i<3; i++){
				sum += tmp[i];
			}
			if(sum<=M && sum>max){
				max = sum;
			}
			return;
		}
		for(int i=start; i<N; i++){
			tmp[cnt] = cards[i];
			comb(cnt+1, i+1);

		}
	}
}
