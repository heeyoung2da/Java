package com.algo.prog.lv1;

import java.util.Arrays;

// x만큼 간격이 있는 n개의 숫자
public class Solution12954 {
	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		Solution12954_ s = new Solution12954_();
		System.out.println(Arrays.toString(s.solution(x, n)));
	}

}
class Solution12954_{
	public long[] solution(int x, int n) {
		long[] answer = new long[n];

		for(int i=0; i<n; i++){
			answer[i] = (long)x * (i+1);
		}
		return answer;
	}
}
