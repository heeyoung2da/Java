package com.algo.baek.dfsbfs;

import java.util.*;

/*
토마토
1은 익은 토마토
0은 익지 않은 토마토
-1은 토마토가 들어있지 않은 칸
1을 찾고 이들은 동시에 퍼짐
모두 익을 때까지의 최소 날짜 출력!
(처음부터 1이라면 0 출력, 끝나고도 익지 않은 토마토가 있다면 -1)
 */
class Dot{
	int x;
	int y;

	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main7576 {
	static int N, M, days;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Dot> tomato;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		tomato = new LinkedList<>();

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				map[i][j] = sc.nextInt();
				// 익은 토마토 담기
				if(map[i][j]==1) tomato.add(new Dot(i,j));
			}
		}

		System.out.println(bfs());

	}

	static int bfs(){

		while(!tomato.isEmpty()){
			Dot dot = tomato.poll();
			for(int d=0; d<4; d++){
				int nr = dot.x + dr[d];
				int nc = dot.y + dc[d];

				// 범위 체크, 토마토가 아니라면 패스
				if(nr<0 || nc<0 || nr>=N || nc>=M || map[nr][nc]!=0) continue;

				map[nr][nc] = map[dot.x][dot.y] + 1;
				tomato.add(new Dot(nr, nc));
			}
		} // while문 끝

		int days = Integer.MIN_VALUE;

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				// 안 익은 토마토가 있다면
				if(map[i][j]==0) return -1;

				days = Math.max(days, map[i][j]);
			}
		}

		// 처음부터 토마토가 모두 익은 상태였다면
		if(days == 1) return 0;
		else
			return days-1;
	}
}
