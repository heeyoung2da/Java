package com.algo.baek.math;

import java.util.Scanner;

// 나머지
public class Main3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[1001];
		for(int i=0; i<10; i++){
			int num = sc.nextInt();
			arr[num%42]++;
		}
		int cnt = 0;
		for(int i=0; i<1001; i++){
			if(arr[i]!=0) cnt++;
		}

		System.out.println(cnt);
	}
}
