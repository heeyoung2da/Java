package com.algo.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 원재의 메모리 복구하기
// 자릿수마다 바뀌는 수 카운트해주기
public class Solution1289_ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++){
			String str = br.readLine();
			char pre = str.charAt(0);
			int cnt = 0;

			for(int i=1; i<str.length(); i++){
				if(pre != str.charAt(i)){
					cnt += 1;
					pre = str.charAt(i);
				}
			}

			if(str.charAt(0)=='1'){
				cnt +=1;
			}

			System.out.println("#"+t+" "+cnt);
		}
	}
}
