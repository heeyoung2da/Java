package com.algo.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 햄버거 다이어트
public class Solution5215{
	static int N, L, max;
	static boolean[] isSelected;
	static int[][] ingredients;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for(int tc=1; tc<=TC; tc++) {
			max = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			isSelected = new boolean[N];
			ingredients = new int[N][2];

			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				ingredients[n][0] = Integer.parseInt(st.nextToken());
				ingredients[n][1] = Integer.parseInt(st.nextToken());
			}// 재료 입력

			subset(0);
			System.out.println("#"+tc+" "+max);
		}
	}

	private static void subset(int cnt) {
		if(cnt==N) {
			int grade = 0, cal = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) { // 부분집합 원소 true인 것만 더해주기
					grade += ingredients[i][0];
					cal+= ingredients[i][1];
				}
				if(cal > L) {
					return;
				}
			}
			max = Math.max(grade, max);
		}else {

			isSelected[cnt] = true;
			subset(cnt+1);

			isSelected[cnt] = false;
			subset(cnt+1);
		}
	}
}
