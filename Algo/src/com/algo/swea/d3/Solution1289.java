package com.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1289{
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int i=0; i<TC; i++){
			int cnt = 0;
			String value = in.readLine();
			char first = value.charAt(0);
			if(first!='0') cnt++;
			for (int j = 1; j < value.length(); j++) {
				if(first !=value.charAt(j)) {
					first = value.charAt(j);
					cnt += 1;
				}
			}
			System.out.printf("#%d %d%n", i+1, cnt);
			
		}
		
	}
	
}
