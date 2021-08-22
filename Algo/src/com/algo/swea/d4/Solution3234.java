package com.algo.swea.d4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 준환이의 양팔저울
public class Solution3234 {
	static int totalCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++){

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			boolean[] isSelected = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			perm(0,0,0, N, arr, isSelected);
			System.out.println("#"+t+" "+totalCnt);
			totalCnt = 0;
		}
	}

	// 우선 N개 중에 N개를 나열해보자
	private static void perm(int cnt, int sumL, int sumR, int N, int[]arr, boolean[]isSelected){
		if(cnt == N){
			totalCnt++;
			return;
		}

		for(int i=0; i<N; i++){
			if(isSelected[i]) continue;

			isSelected[i] = true;

			// 우선 왼쪽에 다 올리고 오른쪽이랑 비교하기
			perm(cnt+1, sumL+arr[i], sumR, N, arr, isSelected);

			// 오른쪽에 올렸을 때 왼쪽보다 작으면 오른쪽에 올릴 수 있음
			if(sumR+arr[i]<=sumL){
				perm(cnt+1, sumL, sumR+arr[i],N, arr, isSelected);
			}

			isSelected[i] = false;
		}
	}

}
