package com.algo.baek.brute;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 연구소
public class Main14502 {
	static class Dot{
		int r, c;
		public Dot(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static List<Dot> virus = new ArrayList<>();
	static int max = 0;
	static int N, M;
	static int[][] map, copied;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		copied = new int[N][M];

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j]==2) virus.add(new Dot(i, j));
			}
		} // 입력 끝

		dfs(0);
		System.out.println(max);

	}

	static void dfs(int depth){
		// 벽 3개 다 세웠다면?
		if(depth == 3){
			// 복사
			copyMap();

			// 바이러스 퍼지게
			for(Dot dot:virus){
				goVirus(dot.r, dot.c);
			}

			// 안전영역 크기
			int safeArea = 0;
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++){
					if(copied[i][j]==0) safeArea++;
				}
			}

			if(max<safeArea) max = safeArea;
			return;
		}

		// 벽 세우기
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j]==0){ 	// 빈칸일 때 -> 벽 세우고
					map[i][j] = 1;
					dfs(depth+1);

					map[i][j]=0;
				}
			}
		}
	}

	// 맵 복사
	static void copyMap(){
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				copied[i][j] = map[i][j];
			}
		}
	}

	static void goVirus(int r, int c){
		for(int i=0; i<4; i++){
			int nr = r+dr[i];
			int nc = c+dc[i];

			if (0 <= nr && nr < N && 0 <= nc && nc < M) {
				if (copied[nr][nc] == 0) {
					copied[nr][nc] = 2;
					goVirus(nr, nc);
				}
			}
		}
	}

}
