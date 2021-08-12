package com.algo;

import java.util.Random;

// 절대값의 합 구하기
public class ArrayOfArray {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] arr;
	static int total = 0;

	public static void main(String[] args) {
		arr = new int[5][5];
		Random random = new Random();
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				arr[i][j] = random.nextInt(25)+1;
			}
		}
		for(int r=0; r<5; r++){
			for(int c=0; c<5; c++){
				move(r, c);
			}
		}

		System.out.println(total);
	}

	private static void move(int r, int c){
		int nr = 0, nc = 0, sum = 0;
		int tmp = arr[r][c]; // 원래의 값

		for(int d=0; d<4; d++){
			nr = r+ dr[d];
			nc = c+ dc[d];

			if(nr<0 || nr>=5 || nc<0 || nc>=5) continue;

			sum += Math.abs(arr[nr][nc]-tmp);
		}
		total += sum;
	}
}
