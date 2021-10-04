package com.algo.baek.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
다리 만들기 2
0: 바다
1: 땅
 */
public class Main17472 {
	static int N, M, island, total, bridgeNum;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static int[] parents;

	static class Dot {
		int x;
		int y;

		public Dot(int x,int y) {
			this.x = x;
			this.y = y ;
		}
	}
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		// bfs로 섬 번호 부여
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					island++;
					bfs(new Dot(i,j));
				}
			}
		}

		// 다리 만들기
		visited = new boolean[N][M];
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j] != 0) bridge(new Dot(i, j), map[i][j]);
			}
		}

		// 크루스칼 알고리즘
		// make set
		parents = new int[island + 1];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		// 다리 선택 MST
		int size = pq.size();
		for(int i=0; i<size; i++){
			Edge edge = pq.poll();

			int a = find(edge.start);
			int b = find(edge.end);

			if(a==b) continue;

			union(edge.start, edge.end);

			total += edge.weight;
			bridgeNum++;
		}
		if(total==0 || bridgeNum!=island-1){ // 모든 섬을 연결하는 것이 불가능하다면
			System.out.println(-1);
		}else{
			System.out.println(total);
		}
	}

	static void bfs(Dot d) {
		Queue<Dot> q = new LinkedList<>();
		visited[d.x][d.y] = true;
		map[d.x][d.y] = island;
		q.add(d);

		while(!q.isEmpty()) {
			Dot dot = q.poll();
			int x = dot.x;
			int y = dot.y;

			for(int i=0; i<4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];

				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] == 1 && !visited[nr][nc]) {
					q.add(new Dot(nr,nc));
					map[nr][nc] = island;
					visited[nr][nc] = true;
				}
			}

		}
	}

	// 다리 연결하기(상하좌우 한 방향으로 계속 직진한 후, 다리 2개이상일 때 다른 섬이 나오면 pq에 넣기)
	static void bridge(Dot dot, int num){
		int nr = dot.x , nc = dot.y;
		int len = 0;

		for(int d=0; d<4; d++){
			while(true){
				nr += dr[d];
				nc += dc[d];

				if(0 <= nr && nr < N && 0 <= nc && nc < M){
					if(map[nr][nc]==num){ // 자신의 섬 번호일 때는 len을 초기화 후 패스
						len = 0;
						nr = dot.x;
						nc = dot.y;
						break;
					}else if(map[nr][nc]==0){ // 바다
						len++;
					}else{ // 바다가 아닌 경우
						if(len>=2){
							pq.add(new Edge(num, map[nr][nc], len));
						}
						len=0;
						nr = dot.x;
						nc = dot.y;
						break;
					}
				}else{
					len = 0;
					nr = dot.x;
					nc = dot.y;
					break;
				}
			}
		}
	}

	public static int find(int x) {
		if (x == parents[x])
			return x;

		return parents[x] = find(parents[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parents[x] = y;
		} else {
			return;
		}
	}
}
