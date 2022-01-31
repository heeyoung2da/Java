package com.algo.prog.lv1;

import java.util.Arrays;

//로또의 최고 순위와 최저 순위
public class Solution77484{
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		Solution77484_ s = new Solution77484_();
		System.out.println(Arrays.toString(s.solution(lottos, win_nums)));
	}
}
class Solution77484_{
	public int[] solution(int[] lottos, int[] win_nums) {
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		int cnt = 0;
		int zero_cnt=0;

		for(int lotto : lottos){
			if(lotto==0){
				zero_cnt++;
				continue;
			}
			for(int num : win_nums){
				if(lotto==num) cnt++;
			}
		}

		int[] answer = new int[2];
		if(7-cnt-zero_cnt>6) answer[0] = 6;
		else answer[0] = 7-cnt-zero_cnt;

		if(7-cnt>6) answer[1] = 6;
		else answer[1] = 7-cnt;

		return answer;
	}
}