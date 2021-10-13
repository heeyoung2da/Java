package com.algo.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 보급로
public class Solution1249 {
	private static final int INF = Integer.MAX_VALUE;
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

			for(int i=0; i<N; i++){
				char[] ch = br.readLine().toCharArray();
				for(int j=0; j<N; j++){
					map[i][j] = ch[j] - '0';
				}
			}

			System.out.println("#"+t+" "+dijkstra(0,0));


		}
	}

	private static int dijkstra(int startR, int startC) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];

		// 최소값이 갱신되도록 큰 값으로 초기화
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				minTime[i][j] = INF;
			}
		}
		minTime[startR][startC] = 0;

		int r=0, c=0, minCost=0, nr, nc;
		while(true){
			// step1
			minCost = INF;
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(!visited[i][j] && minCost > minTime[i][j]){
						minCost = minTime[i][j];
						r=i;
						c=j;
					}
				}
			}
			visited[r][c] = true;
			if(r==N-1 && c==N-1) return minCost;

			// step2 : step1에서 선택된 정점을 경유지로 해서 인접정점 따져보기
			// 이 문제에서는 인접정점이 4방 정점
			for(int d=0; d<4; d++){
				nr = r + dr[d];
				nc = c + dc[d];

				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]
						&&minTime[nr][nc] > minCost + map[nr][nc]){
					minTime[nr][nc] = minCost + map[nr][nc];
				}
			}


		}
	}

}
