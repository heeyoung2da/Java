package com.algo.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Ladder1
public class Solution1210{
	static int[] dx = { 0, -1, 0 }; // 상, 좌, 우
	static int[] dy = { -1, 0, 1 };
	static int nr, nc;
	static int[][] ladder = new int[100][100];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for(int t=1; t<=10; t++) {
			in.readLine();
			// 사다리 입력
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for(int j=0; j<100; j++) {
					ladder[i][j] =Integer.parseInt(st.nextToken());
				}
			}

			int x = 99, y=0;
			for(int i=0; i<100; i++) {
				if(ladder[99][i]==2) {	// 마지막 줄에서 2 찾기
					y=i;
				}
			}

			System.out.println("#"+t+" "+ move(x,y));

		}
	}

	private static int move(int x, int y) {
		int nx =x;
		int ny =y;
		int d = 1;
		while(nx>0) {
			// 상
			if(d==1) {
				nx += dx[d];
				ny += dy[d];

				// 좌
				if(ny>0 && ladder[nx][ny-1]==1) {
					d = 0;
					continue;
				}
				// 우
				else if(ny<99 && ladder[nx][ny+1]==1) {
					d = 2;
					continue;
				}
			}else {
				nx += dx[d];
				ny += dy[d];

				if(nx>0 && ladder[nx-1][ny]==1) {
					d = 1; // 위로 가자
					continue;
				}
			}
		}
		return ny;
	}
}
