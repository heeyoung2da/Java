package com.algo.baek.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
미세먼지 안녕!
 */
public class Main17144 {
	static class Dust{
		int x, y, amount;

		public Dust(int x, int y, int amount) {
			this.x = x;
			this.y = y;
			this.amount = amount;
		}
	}
	static int R,C,T;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static List<Integer> airCleaner;
	static Queue<Dust> dusts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		airCleaner = new ArrayList<>();

		for(int i=0; i<R; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++){
				map[i][j] = Integer.parseInt(st.nextToken());

				// 공기청정기 위치 저장
				if(map[i][j]== -1) airCleaner.add(i);
			}
		}
		while (T-- > 0){
			// 1. 미세먼지 확산
			goDust();
			// 2. 공기청정기 작동
			operate();
		}

		int sum = 0;
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(map[i][j]==-1) continue;
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
	// 미세먼지 찾기
	static void findDust(){
		dusts = new LinkedList<>();

		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				// 미세먼지가 없거나 공기청정기라면 패스
				if(map[i][j]==-1 || map[i][j]==0) continue;
				dusts.add(new Dust(i, j, map[i][j]));
			}
		}
	}
	// 미세먼지 확산
	static void goDust(){
		// 미세먼지 찾기
		findDust();

		while (!dusts.isEmpty()){
			Dust dust = dusts.poll();

			// 5이하라면?
			if(dust.amount<5) continue;

			int goAmount = dust.amount / 5;
			int cnt = 0;

			for(int d=0; d<4; d++){
				int nr = dust.x + dr[d];
				int nc = dust.y + dc[d];

				// 범위 체크, 공기청정기가 있다면
				if(nr<0 || nc<0 || nr>=R || nc>=C || map[nr][nc]== -1 ) continue;

				map[nr][nc] += goAmount;
				cnt++;
			}
			// (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수)
			map[dust.x][dust.y] -= goAmount * cnt;
		}
	}

	static void operate(){
		// 위쪽은 반시계방향
		int top = airCleaner.get(0);

		for (int i = top - 1; i > 0; i--) map[i][0] = map[i-1][0];
		for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i+1];
		for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
		for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i-1];

		// 아래쪽은 시계방향
		int bottom = airCleaner.get(1);

		for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
		for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
		for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
		for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];

		map[top][1] = 0;
		map[bottom][1] = 0;
	}
}
