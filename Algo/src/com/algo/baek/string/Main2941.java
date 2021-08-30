package com.algo.baek.string;

import java.util.Scanner;

// 크로아티아 알파벳
public class Main2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int cnt = 0;
		int size = str.length();

		for(int i=0; i<size; i++){

			if(str.charAt(i)=='c' && i<size-1){
				if(str.charAt(i+1)=='='||str.charAt(i+1)=='-'){
					i++;
				}
			}else if(str.charAt(i)=='d'&& i<size-1){
				if(str.charAt(i+1)=='z'&& i<size-2){
					if(str.charAt(i+2)=='='){
						i+=2;
					}
				}else if(str.charAt(i+1)=='-'){
					i++;
				}
			}else if((str.charAt(i)=='l' || str.charAt(i)=='n')&& i<size-1){
				if(str.charAt(i+1)=='j'){
					i++;
				}
			}else if((str.charAt(i)=='s'|| str.charAt(i)=='z')&& i<size-1){
				if(str.charAt(i+1)=='='){
					i++;
				}
			}

			cnt++;
		}
		System.out.println(cnt);
	}
}
