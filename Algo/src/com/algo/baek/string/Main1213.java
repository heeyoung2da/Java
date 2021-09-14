package com.algo.baek.string;

import java.util.Arrays;
import java.util.Scanner;

/*
팰린드롬 만들기 -> 런타임 에러로 실패함(접근 실패)
길이가 짝수면 모든 알파벳의 개수도 짝수
1. 0 - abc.length까지 abc[i]/2만큼 출력
2. 홀수일 경우 홀수 알파벳 출력
3. abc.length ~ 0까지 abc[i]/2만큼 출력
 */
public class Main1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int len = str.length();

		int[] abc = new int[26];

		for(int i=0; i<len; i++){
			abc[str.charAt(i)-'A']++;
		}

		int oddCnt = 0, oddIdx = 0;
		for(int i=0; i<abc.length; i++){
			if(abc[i]%2==1){
				oddCnt++;
				oddIdx = i;
			}
		}

		if ((len % 2 == 0 && oddCnt > 0) || (len % 2 == 1 && oddCnt != 1)) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}

		for(int i=0; i<abc.length; i++){
			for(int j=0; j<abc[i]/2; j++){
				System.out.print((char)(i+'A'));
			}
		}

		if (len % 2 == 1) {
			System.out.print((char)(oddIdx+'A'));
		}

		for(int i=25; i>=0; i--){
			for(int j=0; j<abc[i]/2; j++){
				System.out.print((char)(i+'A'));
			}
		}
	}
}
