package com.algo.baek.io;

import java.util.Scanner;

public class Main10953 {
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int i=0; i<T; i++){
		String[] arr = sc.next().split(",");
		System.out.println(Integer.parseInt(arr[0])+Integer.parseInt(arr[1]));
	}
}
}
