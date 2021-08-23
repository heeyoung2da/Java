package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 요리사
public class Solution4012 {
	static int N, min;
	static boolean[] isSelected;
	static int[][] table;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t<=T; t++){
			N = Integer.parseInt(br.readLine());
			table = new int[N][N];
			min = Integer.MAX_VALUE;
			isSelected = new boolean[N];

			for(int i=0; i<N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++){
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력

			sb.append("#"+t+" ");
			comb(0,0);
			sb.append(min+"\n");
		}
		System.out.println(sb);
	}
	// N/2 식재료 배분
	private static void comb(int cnt, int start){
		if(cnt==N/2){
			calc();
			return;
		}
		for(int i=start; i<N; i++){
			isSelected[i] = true;
			comb(cnt+1, i+1);
			isSelected[i] = false;
		}
	}

	// A, B 식재료 맛 차이 계산
	private static void calc(){
		int A = 0, B = 0, ans = 0;

		for(int i=0; i<N; i++){
			for(int j=i; j<N; j++){
				if(isSelected[i] && isSelected[j]){
					A += table[i][j]+table[j][i];
				}
				else if(!isSelected[i] && !isSelected[j]) {
					B += table[i][j]+table[j][i];
				}
			}
		}
		ans = Math.abs(A-B);
		min = Math.min(ans, min);
	}
}
