package com.algo.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Flatten
public class Solution1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			// 덤프 횟수 입력
			int dCnt = Integer.parseInt(in.readLine());

			Integer[] box = new Integer[100];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int diff = 100;

			// 박스 높이 입력
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}

			// 알고리즘
			while (dCnt-- > 0) {
				Arrays.sort(box);
				if (box[99] - box[0] > 1) {
					box[99] -= 1;
					box[0] += 1;
				} else {
					break;
				}
			}
			Arrays.sort(box);
			System.out.printf("#%d %d%n", tc, box[99] - box[0]);
		}
	}
}