package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
무선충전
두 사람이 사용한 최대 충전
 */
public class Solution5644 {
	static int M, A;
	static int[] dr ={0, -1, 0, 1, 0};	// 이동X, 상, 우, 하, 좌
	static int[] dc ={0, 0, 1, 0, -1};
	static int[] moveA, moveB, playerA, playerB;
	static int[][] bc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		playerA = new int[2];
		playerB = new int[2];

		for(int t=1; t<=T; t++){

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());	// 총 이동시간
			A = Integer.parseInt(st.nextToken());	// BC의 개수

			moveA = new int[M+1];
			moveB = new int[M+1];
			bc = new int[A][4];

			playerA[0] = 1;
			playerA[1] = 1;
			playerB[0] = 10;
			playerB[1] = 10;

			// 사용자 이동
			 st = new StringTokenizer(br.readLine());
			for(int i=1; i<M+1; i++){
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<M+1; i++){
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			// BC의 정보
			for(int i=0; i<A; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++){
					bc[i][0] = Integer.parseInt(br.readLine());	// x
					bc[i][1] = Integer.parseInt(br.readLine());	// y
					bc[i][2] = Integer.parseInt(br.readLine()); // 거리
					bc[i][3] = Integer.parseInt(br.readLine());	// 충전
				}
			}
		}
	}

	private static int move(){
		int total = 0;

		for(int i=0; i<=M+1; i++){
			// A, B 위치 변경
			playerA[0] += dr[moveA[i]];
			playerA[1] += dc[moveA[i]];
			playerA[0] += dr[moveB[i]];
			playerA[1] += dc[moveB[i]];

			total += getCharge();
		}
		return total;
	}
	private static int getCharge(){
		int max = Integer.MIN_VALUE;
		for(int a=0; a<A; a++){
			for(int b=0; b<A; b++){
				int sum = 0;
				int chargeA = check(a, playerA[0], playerA[1]);
				int chargeB = check(b, playerB[0], playerB[1]);

				// 충전소가 같다면? 둘 중에 큰 값
				if(a == b){
					sum = Math.max(chargeA, chargeB);
				}else{
					sum = chargeA + chargeB;
				}
			}
		}
		return max;
	}

	private static int check(int a, int x, int y){
		int distance = Math.abs(bc[a][0]-x)+Math.abs(bc[a][1]-y);
		// 충전기 a부터 충전할 수 있는 거리이면 충전량 리턴
		if(distance<=bc[a][2]) return bc[a][3];
		else return 0;
	}
}
