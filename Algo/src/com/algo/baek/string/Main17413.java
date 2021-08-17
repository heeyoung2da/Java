package com.algo.baek.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 단어 뒤집기2
public class Main17413 {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		boolean markChk = false;

		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			// < >
			if (c == '<') {
				popFunc(stack);
				markChk = true;
				sb.append(c);
			} else if (c == '>') {
				markChk = false;
				sb.append(c);
			} else if (markChk) {
				sb.append(c);
			} else {
				if (c == ' ') {
					popFunc(stack);
					sb.append(c);
				} else {
					// 단어만
					stack.push(c);
				}
			}
		}
		popFunc(stack);
		System.out.print(sb);
	}
	private static void popFunc(Stack<Character> stack){
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}

