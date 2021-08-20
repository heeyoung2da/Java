package com.algo.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사칙연산 유효성 검사
public class Solution1233{
	static String[] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder("");
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 1;
			tree = new String[N+1];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken();
			
			} // 정점 정보 입력
			for(int i=1; i<N+1; i++) {
				// 리프노드에는 숫자만
				if('0'<=tree[i].charAt(0) && tree[i].charAt(0)<='9') {
					if(i<=N/2) {
						ans = 0;
						break;
					}
				}else { 
					if(i>N/2) {
						ans = 0;
						break;
					}
				}
			}
			
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);
		
	}
}
