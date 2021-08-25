package com.algo.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 규영이와 인영이의 카드게임
public class Solution6808 {
	static ArrayList<Integer> ky = new ArrayList<>();
	static ArrayList<Integer> cards = new ArrayList<>();
	static int[] iy;
	static final int SIZE = 9;
    static int win, lose;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			win = 0; 
			lose = 0;
			iy = new int[SIZE];

			for(int i=0; i<SIZE; i++) {
				ky.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i=1; i<19; i++) {
				if(!ky.contains(i)) {
					cards.add(i);
				}
			}
			perm(0, 0);
			System.out.println("#"+t+" "+win+" "+lose);
			ky.clear();
			cards.clear();
		}
	}
	
	static void perm(int cnt, int flag) {
		if(cnt == SIZE){
			calc();
		}
		for(int i=0; i<SIZE; i++) {
			if((flag&1<<i)!=0) continue;
			
			iy[cnt] = cards.get(i);
			
			perm(cnt+1, flag | (1<<i));
		}
	}
	
	static void calc() {
		int kyScore = 0, iyScore = 0;
		
		for(int i=0; i<SIZE; i++) {
			if(ky.get(i)> iy[i]) { 	// 규영이 점수가 클 때
				kyScore += ky.get(i)+iy[i];
			}else {
				iyScore += ky.get(i)+iy[i];
			}
		}
		if(kyScore>iyScore) win++;
		else if(kyScore<iyScore) lose++;
	}
}
