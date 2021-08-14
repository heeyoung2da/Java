package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 기지국
public class Solution0 {
	static int N;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};// 상하좌우
	static int[] dc ={0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++){
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			int cnt = 0;

			for(int i=0; i<N; i++){
				map[i] = (br.readLine()).toCharArray();
			}

			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(map[i][j]=='A'){
						move(i, j, 1);
					}
					if(map[i][j]=='B'){
						move(i, j, 2);
					}
					if(map[i][j]=='C'){
						move(i, j, 3);
					}

				}
			}
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(map[i][j]=='H') cnt++;
				}
			}

			System.out.println("#"+t+" "+cnt);
		}
	}

	private static void move(int r, int c, int dCnt){

		for(int d=0; d<4; d++){
			int nr = r, nc = c;
			for(int i = 0; i<dCnt; i++){
				nr += dr[d];
				nc += dc[d];

				if(0<=nr && nr<N && 0<=nc && nc<N && map[nr][nc]=='H'){
					map[nr][nc] = 'X';
				}
			}
		}
	}
}
