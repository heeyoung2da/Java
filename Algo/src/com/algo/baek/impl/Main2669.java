package com.algo.baek.impl;

import java.util.Scanner;

// 직사각형 네개의 합집합의 면적 구하기
public class Main2669 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int area = 0;
		int[][] map = new int[101][101];
		for(int t=0; t<4; t++){
			int leftX = sc.nextInt();
			int leftY = sc.nextInt();
			int rightX = sc.nextInt();
			int rightY = sc.nextInt();

			for(int x=leftX; x<rightX; x++){
				for(int y=leftY; y<rightY; y++){
					if(map[x][y]!=1){
						map[x][y] = 1;
						area++;
					}
				}
			}
		}
		System.out.println(area);
	}
}
