package com.algo.baek.dfs;

import java.util.Scanner;

/*
빵집
https://www.acmicpc.net/problem/3109
 */
public class Main3109 {
	static int R,C;
	static char[][] arr;
	static int[] dr={-1,0,1};		// 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선
	static int[] dc={1,1,1};
	static boolean check;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][];

		for(int r = 0; r<R; r++){
			arr[r] = sc.next().toCharArray();
		}// 입력


		cnt = 0;

		for(int i=0; i<R; i++){
			check = false;
			dfs(i, 0);
		}

		System.out.println(cnt);

	}
	private static void dfs(int r, int c){
		// 오른쪽 끝까지 왔을 때
		if(c==C-1){
			check = true;
			cnt++;
			return;
		}

		// 오른쪽, 대각선 위 아래 검사
		for(int d=0; d<3; d++){
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 범위 체크
			if(nr < 0 || nr>=R || nc <0|| nc>=C || arr[nr][nc]=='x') continue;

			arr[nr][nc] = 'x';
			dfs(nr, nc);
			if(check){
				return;
			}
		}
	}
}
