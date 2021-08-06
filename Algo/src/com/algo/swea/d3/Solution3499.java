package com.algo.swea.d3;

import java.io.BufferedReader;
		import java.io.FileInputStream;
		import java.io.IOException;
		import java.io.InputStreamReader;
		import java.util.LinkedList;
		import java.util.Queue;
		import java.util.StringTokenizer;

// 퍼펙트 셔플
public class Solution3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		Queue<String> queue1 = new LinkedList<>();
		Queue<String> queue2 = new LinkedList<>();

		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			int mid = (int) Math.ceil(N/2.0);

			for(int i=0; i<mid; i++) {
				queue1.offer(st.nextToken());
			}

			for(int i=mid; i<N; i++) {
				queue2.offer(st.nextToken());
			}

			System.out.print("#"+t);
			for(int i=0; i<mid; i++) {
				System.out.print(" "+queue1.poll());
				if(!queue2.isEmpty()) {
					System.out.print(" "+queue2.poll());
				}
			}
			System.out.println();
		}
	}
}
