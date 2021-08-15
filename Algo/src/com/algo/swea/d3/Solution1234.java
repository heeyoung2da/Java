package com.algo.swea.d3;

import java.util.Scanner;
import java.util.Stack;

// 비밀번호
public class Solution1234 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();

		for(int t=1; t<=10; t++){
			int N = sc.nextInt();
			String str = sc.next();
			for(int i=0; i<N; i++){

				if(!stack.isEmpty() && stack.peek()==str.charAt(i)){
					stack.pop();
				}else{
					stack.push(str.charAt(i));
				}
			}

			String result = "";
			while(!stack.isEmpty()){
				result = stack.pop() + result;
			}
			System.out.println("#"+t+" "+ result);
		}
	}
}
