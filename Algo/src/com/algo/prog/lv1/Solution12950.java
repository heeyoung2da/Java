package com.algo.prog.lv1;

import java.util.Arrays;

// 행렬의 덧셈
public class Solution12950 {
	public static void main(String[] args) {
		int[][] arr1 = {{1, 2},{2, 3}};
		int[][] arr2 = {{3, 4},{5, 6}};

		Solution12950_ s = new Solution12950_();
		System.out.println(Arrays.deepToString(s.solution(arr1, arr2)));
	}
}

class Solution12950_ {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int N = arr1.length;
		int M = arr1[0].length;

		int[][] answer = new int[N][M];

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return answer;
	}
}