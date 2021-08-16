package com.algo.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성시의 버스 노선 -> 런타임 에러
public class Solution6485_실패 {
	static int[][] input;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int t=1; t<=T; t++){
			int N = Integer.parseInt(br.readLine());
			input = new int[N][2];
			for(int i=0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
			}
			int P = Integer.parseInt(br.readLine());
			sb.append("#"+t);
			for(int p=0; p<P; p++){
				cnt = 0;
				int num = Integer.parseInt(br.readLine());
				for(int i=0; i<N; i++){
					if(input[i][0]<=num&&num<=input[i][1]) cnt++;
				}
				sb.append(" "+cnt);
			}
			System.out.println(sb);
		}
		br.close();
	}
}
