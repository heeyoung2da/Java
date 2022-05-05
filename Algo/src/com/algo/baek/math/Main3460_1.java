package com.algo.baek.math;

import java.util.Scanner;

// 이진수 > Integer.toBinaryString()
public class Main3460_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++){
			int n = sc.nextInt();
			String Binary = Integer.toBinaryString(n); // 이진수로 치환하는 방법
			System.out.println(Binary);
		}
	}
}
