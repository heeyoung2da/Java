package com.algo.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

// 건초더미
public class Solution5603 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t=1; t<=T; t++){
			int N = sc.nextInt();
			int[] arr = new int[N];
			int cnt =0, sum=0;

			for(int i=0; i<N; i++){
				arr[i] = sc.nextInt();
				sum += arr[i];
			}

			int mid = sum / N;
			for(int i=0; i<N; i++){
				if(arr[i]-mid>0) cnt += arr[i]-mid;
				else cnt += mid - arr[i];
			}
			System.out.println("#"+t+" "+cnt/2);
		}
	}
}
