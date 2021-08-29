package com.algo.baek.implementation;

import java.util.Scanner;

// 주사위 쌓기
public class Main2116 {
	static int[][] dice;
	static int sum, ans = 0, top;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dice = new int[N][6];

		for(int i=0; i<N; i++){
			for(int j=0; j<6; j++){
				dice[i][j] = sc.nextInt();
			}
		} // 입력

		// 1번 주사위 아랫면 결정하기
		for(int i=0; i<6; i++){
			sum = 0;
			int bottom = dice[0][i];
			findTop(0, bottom);

			for(int j=1; j<N; j++){
				findTop(j, top);
			}
//			System.out.println("sum: "+sum);
			if(sum>ans) ans =sum;
		}
		System.out.println(ans);
	}
	// 아랫면, 윗면을 제외한 숫자 중에서 가장 큰 수 sum에 저장
	private static void calc(int top, int bottom, int index){
		int maxNum = 1;
		for(int i=0; i<6; i++) {
			if(dice[index][i]==top || dice[index][i]==bottom) continue;
			if(maxNum<dice[index][i]) maxNum = dice[index][i];
		}

		sum += maxNum;
	}

	// bottom 찾고 -> calc
	private static void findTop(int index, int bottom){
//		System.out.println("bottom: "+bottom);
		for(int i=0; i<6; i++){
			if(bottom==dice[index][i]){
//				System.out.println("i: "+i);
				// 윗면 찾기
				if(i==0){
					top = dice[index][5];
				}else if(i==1){
					top = dice[index][3];
				}else if(i==2){
					top = dice[index][4];
				}else if(i==3){
					top = dice[index][1];
				}else if(i==4){
					top = dice[index][2];
				}else if(i==5){
					top = dice[index][0];
				}
			}
		}
//		System.out.println("top: "+top);
		calc(top, bottom, index);
	}
}
