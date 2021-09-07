package com.algo.baek.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
연결 요소의 개수
 */
public class Main11724 {
	static ArrayList<Integer>[] list;
	static int N;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];

		for(int i=1; i<=N; i++){
			list[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list[u].add(v);
			list[v].add(u);
		}

		visited = new boolean[N+1];

		for(int i=1; i<=N; i++){
			if(!visited[i]){
				bfs(i);
			}
		}
		System.out.println(cnt);
	}

	private static void bfs(int start){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		cnt++;

		while(!queue.isEmpty()){
			int v = queue.poll();

			for(int w : list[v]){
				if(!visited[w]){
					queue.add(w);
					visited[w] = true;
				}
			}

		}
	}
}
