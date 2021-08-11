package com.algo.baek.recursive;

import java.util.Scanner;

public class Main11729 {
	private static int N, cnt=0;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		move(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}
	// 출발지, 빈 곳, 목적지
	private static void move(int N, int s, int temp, int d) {
		++cnt;
		// 기저
		if (N == 1) {
			sb.append(s + " " + d + "\n");
			return;
		}

		// N-1을 2번째에 놓기
		move(N - 1, s, d, temp);

		// 큰 거 목적지에
		sb.append(s + " " + d + "\n");

		// 2번째에 있는 N-1개를 목적지로
		move(N - 1, temp, s, d);
	}
}
