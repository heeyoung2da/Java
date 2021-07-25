package com.hy.algo.io;

import java.util.Scanner;

public class Baek_2558 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		sc.close(); // 불필요한 리소스 낭비를 막기 위해 입력을 받은 후에는 종료

		System.out.println(num1+num2);
	}
}
