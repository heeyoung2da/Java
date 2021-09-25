package com.algo.baek.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
토마토
1은 익은 토마토
0은 익지 않은 토마토
-1은 토마토가 들어있지 않은 칸
1을 찾고 이들은 동시에 퍼짐
모두 익을 때까지의 최소 날짜 출력!
(처음부터 1이라면 0 출력, 끝나고도 익지 않은 토마토가 있다면 -1)
 */
public class Main7576_다른풀이 {
	static int N, M, cnt, days=0;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<int[]> tomato;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		tomato = new LinkedList<>();

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				map[i][j] = sc.nextInt();

				if(map[i][j]==1) tomato.add(new int[]{i,j}); 	// 익은 토마토
				else if(map[i][j]==0) cnt++;					// 익지 않은 토마토
			}
		}

		bfs();

	}

	static void bfs() {
		while (cnt > 0 && !tomato.isEmpty()) {
			for(int i= tomato.size(); i>0; i--){
				int[] cur = tomato.poll();

				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];

					// 범위 체크, 토마토가 아니라면 패스
					if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != 0) continue;

					cnt--;
					map[nr][nc] = 1;
					tomato.add(new int[]{nr, nc});
				}
			}
			days++;
		} // while문 끝
		System.out.println(cnt==0 ? days: -1);
	}
}
