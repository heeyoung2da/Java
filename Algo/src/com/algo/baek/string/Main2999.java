package com.algo.baek.string;

import java.util.Scanner;

// 비밀 이메일
public class Main2999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		int size = str.length();

		int R = 1, C = size;
		for(int i=2; i<=size; i++){
			if(size%i==0){
				int tmp = size/i;

				if(tmp>size/tmp){
					continue;
				}
				if(tmp>R){
					R = tmp;
					C = size/R;
				}
			}
		}

//		System.out.println(R+" "+C);

		char[][] arr = new char[R][C];
		int idx = 0;
		for(int i=0; i<C; i++){
			for(int j=0; j<R; j++){
				arr[j][i] = str.charAt(idx++);
			}
		}

		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				System.out.print(arr[i][j]);
			}
		}
	}
}
