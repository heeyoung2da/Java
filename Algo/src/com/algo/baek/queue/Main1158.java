package com.algo.baek.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 요세푸스 문제
public class Main1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		int[] result = new int[N];

		sb.append("<");
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		int cnt = 0;

		while (queue.size() > 1) {
			cnt++;
			if (cnt == K) {
				sb.append(queue.poll() + ", ");
				cnt = 0;
			} else {
				queue.add(queue.poll());
			}
		}
		sb.append(queue.poll() + ">");

		System.out.println(sb.toString());
	}
}
