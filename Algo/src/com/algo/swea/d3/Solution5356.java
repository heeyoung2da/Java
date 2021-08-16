package com.algo.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

// 의석이의 세로로 말해요
public class Solution5356 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			char[][] arr = new char[5][];
			int max = 0;

			for (int i = 0; i < 5; i++) {
				arr[i] = sc.next().toCharArray();
				if (max < arr[i].length) {
					max = arr[i].length;
				}
			}

			sb.append("#"+t+" ");
			for(int i=0; i<max; i++) {
				for (int j = 0; j < 5; j++) {
					if(arr[j].length<=i) continue;
					sb.append(arr[j][i]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
