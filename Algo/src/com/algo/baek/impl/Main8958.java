package com.algo.baek.impl;

import java.util.Scanner;

// OX퀴즈
public class Main8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for(int i=0; i<N; i++){
			String str = sc.next();
			int sum = 0;
			int grade = 1;
			for(int s=0; s<str.length(); s++){
				if(str.charAt(s)=='O'){
					sum+=grade;
					grade++;
				}else{
					grade = 1;
				}
			}
			System.out.println(sum);
		}
	}
}
