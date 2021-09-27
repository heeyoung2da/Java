package com.algo.baek.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/*
숫자놀이
 */
public class Main1755 {

	static class Word implements Comparable<Word>{
		String str;
		int num;

		public Word(String str, int num) {
			this.str = str;
			this.num = num;
		}

		@Override
		public int compareTo(Word o) {
			return this.str.compareTo(o.str);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		String[] dict = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		ArrayList<Word> list = new ArrayList<>();

		for(int i=M; i<=N; i++){
			String tmp = Integer.toString(i);
			char[] c = tmp.toCharArray();

			StringBuilder sb = new StringBuilder();
			for(int j=0; j<c.length; j++){
				sb.append(dict[c[j]-'0']);
//				if(c.length>1){
//					sb.append(" ");
//				}
			}

			list.add(new Word(sb.toString(), i));
		}

		Collections.sort(list);

		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i).num+" ");
			if((i+1)%10==0) System.out.println();
		}
	}
}
