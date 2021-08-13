package com.algo.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 보급로
public class Solution1249 {
	static int N;
	static int[][] map, visited;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for(int t =1; t<=T; t++){
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			move(0,0);

		}
	}
	private static void move(int r, int c){
		int nr = r, nc = c, cnt=0;
		visited = new int[N][N];

		for(int d=0; d<4; d++){
			nr += dr[d];
			nc += dc[d];

			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc] ==1) continue;

			visited[nr][nc] = 1;
			cnt++;

		}
	}
}
