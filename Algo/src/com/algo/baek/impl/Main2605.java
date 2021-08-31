package com.algo.baek.impl;

import java.util.ArrayList;
import java.util.Scanner;

// 줄 세우기
public class Main2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; i++){
			int num = sc.nextInt();
			if(num==0){
				list.add(i);
			}else{
				list.add(list.size()-num, i);
			}
		}

		for(int i=0; i<N; i++){
			System.out.print(list.get(i)+" ");
		}
	}
}
