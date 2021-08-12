package com.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최빈수 구하기
public class Solution1204 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for(int t=1; t<=T; t++){
			int[] grades = new int[101];
			br.readLine();
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<1000; i++){
				grades[Integer.parseInt(st.nextToken())]++;
			}

			int max = 0, ans=0;
			for(int i =100; i>=0; i--){
				if(max<grades[i]){
					max = grades[i];
					ans = i;
				}
			}

			System.out.println("#"+t+" "+ans);
		}
	}
}
