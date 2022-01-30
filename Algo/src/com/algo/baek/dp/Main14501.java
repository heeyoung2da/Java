package com.algo.baek.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사
/*
접근 방법:
dp[day] = max(dp[day+1], dp[day+T[day]] + P[day]

day에서 시작해서 퇴사일까지 최대값을 dp[day]에 저장
- 오늘 스케줄을 하는 경우: dp[day+T[day]] + P[day]
- 오늘 스케줄을 안 하는 경우: dp[day+1]
 */
public class Main14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N];
		int[] P = new int[N];
		int[] dp = new int[N+1];

		StringTokenizer st;
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());

			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		for(int i=0; i<N; i++){
			int day = i+T[i];
			if(day<=N){
				dp[day] = Math.max(dp[day], dp[i]+P[i]);
			}

			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}

		System.out.println(dp[N]);

	}
}
