package com.algo.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성시의 버스 노선
public class Solution6485 {
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++){
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			arr = new int[5001];

			for(int i=0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				for(int j = A; j<=B; j++){
					arr[j]++;
				}
			}
			sb.append("#"+t);
			int P = Integer.parseInt(br.readLine());
			for(int p=0; p<P; p++){
				int tmp = Integer.parseInt(br.readLine());
				sb.append(" "+arr[tmp]);
			}
			System.out.println(sb);
		}
		br.close();
	}
}
