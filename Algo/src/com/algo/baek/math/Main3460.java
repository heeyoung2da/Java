package com.algo.baek.math;

import java.util.Scanner;

// 이진수
public class Main3460 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++){
			int n = sc.nextInt();
			int cnt = 0;

			while(n/2>0){
				if(n%2==1){
					System.out.print(cnt+" ");
				}
				n=n/2;
				cnt+=1;
			}
			System.out.println(cnt);
		}
	}
}
