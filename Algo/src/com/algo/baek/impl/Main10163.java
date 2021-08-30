package com.algo.baek.implementation;

import java.util.Scanner;

// 색종이
public class Main10163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] area = new int[1001][1001];

		for(int n=1; n<=N; n++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();

			for(int i=x; i<x+width; i++){
				for(int j=y; j<y+height; j++){
					area[i][j] = n;
				}
			}
		}

		for(int n=1; n<=N; n++){
			int cnt=0;
			for(int i=0; i<1001; i++){
				for(int j=0; j<1001; j++){
					if(area[i][j]==n) cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
