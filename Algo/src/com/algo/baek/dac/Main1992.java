package com.algo.baek.dac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
쿼드트리
https://www.acmicpc.net/problem/1992
 */
public class Main1992 {
	static char[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		divide(0, 0, N);
		System.out.println(sb);
	}

	private static void divide(int r, int c, int size) {

		// 0, 1 확인
		if (numberCheck(r, c, size)) {
			if(arr[r][c]=='0'){
				sb.append(0);
			}else{
				sb.append(1);
			}
			return;
		}
		int mid = size / 2;

		sb.append("(");
		divide(r, c, mid);					// 2사분면
		divide(r, c+mid, mid);			// 1사분면
		divide(r+mid, c, mid);			// 3사분면
		divide(r+mid, c+mid, mid);	// 4사분면
		sb.append(")");
	}

	private static boolean numberCheck(int r, int c, int size) {
		// 체크할 숫자
		char num = arr[r][c];

		for(int i=r; i<r+size; i++){
			for(int j=c; j<c+size; j++){
				if(arr[i][j]!=num){
					return false;
				}
			}
		}

		return true;
	}
}
