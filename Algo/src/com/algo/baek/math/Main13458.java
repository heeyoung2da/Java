package com.algo.baek.math;

import java.util.Scanner;

/*
시험 감독
시험장의 개수가 최대 1,000,000이고 학생 수도 시험장당 최대 1,000,000이므로
최악의 경우 백만 * 백만 = 1조이므로 결과값을 int형이 아닌 long형으로 선언해야 함...
 */
public class Main13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 총 N개의 시험장
		int N = sc.nextInt();

		int[] A = new int[N];
		// 각 시험장에 있는 응시자 수
		for(int n=0; n<N; n++){
			A[n] =sc.nextInt();
		}

		// 총감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명
		int B = sc.nextInt();

		// 부감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 C명
		int C = sc.nextInt();

		// 각 시험장마다 응시생들을 모두 감시. 이때 필요한 감독관의 수의 최솟값?
		// 각각의 시험장에 총감독관은 오직 1명, 부감독관은 여러 명 가능

		long cnt = 0;
		for(int i=0; i<N; i++){
			A[i] -= B; // 총감독관
			cnt++;
			if(A[i]>0){
//				cnt += Math.ceil(A[i]/(C+0.0));
				if (A[i]/C<1){
					cnt++;
				}else {
					cnt += A[i]/C;
					if(A[i]%C!=0) cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}
