package com.algo.baek.dfsbfs;


import com.sun.tools.javac.util.ListBuffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
DFS와 BFS
https://www.acmicpc.net/problem/1260
 */
public class Main1260 {
	static ArrayList<Integer>[] list;
	static int N;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1]; //인접리스트

		for(int i=1; i<=N; i++){
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			// 양방향
			list[from].add(to);
			list[to].add(from);
		}
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
	}

	// 재귀
	private static void dfs(int v){
		if(visited[v]) return;

		visited[v] = true;
		System.out.print(v+" ");
		for(int w : list[v]){
			if(!visited[w]) dfs(w);
		}
	}

	private static void bfs(int start){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while(!queue.isEmpty()){
			int v = queue.poll();
			System.out.print(v+" ");
			for(int w: list[v]){
				if(!visited[w]){
					visited[w] = true;
					queue.add(w);
				}
			}
		}
	}
}
