package com.algo.baek.io;

import java.util.Scanner;

public class Baek_11021 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=1; i<=T; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("Case #%d: %d%n",i,a+b);
		}
	}
}