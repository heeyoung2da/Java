package com.algo.swea.d2;

import java.util.Arrays;
import java.util.Scanner;

// 숫자를 정렬하자
public class Solution1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++){
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++){
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.print("#"+t);
			for(int i=0; i<N; i++){
				System.out.print(" "+arr[i]);
			}
			System.out.println();
		}
	}
}
