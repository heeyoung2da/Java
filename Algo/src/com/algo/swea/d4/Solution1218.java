package com.algo.swea.d4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

// 괄호 짝짓기
public class Solution1218{
	public static void main(String[] args) throws FileNotFoundException {		
//		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		for(int t=1; t<=10; t++) {
			// 입력
			int N = sc.nextInt();
			String s = sc.next();
			Stack<Character> stack = new Stack<Character>();
			int ans = 0;

			for(int i=0; i<N; i++) {

				if(s.charAt(i)=='}' && stack.peek()=='{') {
					stack.pop();
				}
				else if(s.charAt(i)=='>' && stack.peek()=='<') {
					stack.pop();
				}
				else if(s.charAt(i)==')' && stack.peek()=='(') {
					stack.pop();
				}
				else if(s.charAt(i)==']' && stack.peek()=='[') {
					stack.pop();
				}else {
					stack.push(s.charAt(i));
				}
			}

			if(stack.isEmpty()) ans=1;
			else ans =0;

			System.out.println("#"+t+" "+ans);
		}
	}
}


