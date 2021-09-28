package com.algo.baek.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
양팔저울
 */
public class Main2629 {
	static int chuNum;
	static int[] chuArr;
	static boolean[][] isPossible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		chuNum = Integer.parseInt(br.readLine());
		chuArr = new int[chuNum];
		isPossible = new boolean[chuNum+1][15001]; // 추 무게의 최대 총합은 15000

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<chuNum; i++){
			chuArr[i] =  Integer.parseInt(st.nextToken());
		}

		dfs(0,0);

		int marbleNum = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<marbleNum; i++){
			int marbleW = Integer.parseInt(st.nextToken());

			if(marbleW>15000){
				sb.append("N ");
			}else{
				if (isPossible[chuNum][marbleW]) {
					sb.append("Y ");
				}else{
					sb.append("N ");
				}
			}
		}

		System.out.println(sb);
	}

	static void dfs(int cnt, int w){
		if(isPossible[cnt][w]) return;

		isPossible[cnt][w] = true;

		if(cnt == chuNum) return;

		// 한 쪽에 추가로 놓은 경우
		dfs(cnt+1, w+chuArr[cnt]);
		// 아무 쪽에도 놓지 않은 경우
		dfs(cnt+1, w);
		// 반대 쪽에 놓은 경우(구슬과 함께)
		dfs(cnt+1, Math.abs(w-chuArr[cnt]));
	}
}
