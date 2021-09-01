package com.algo.baek.brute;

import java.util.Arrays;
import java.util.Scanner;

/*
일곱 난쟁이
- 내가 푼 방법: 조합 구해서 목표합에 도달했을 때 정답 배열에 저장
- 다른 사람들이 푼 방법:
입력에서 모든 난쟁이들의 키를 더해주고
그 총합에서 두 난쟁이를 뺀 값이 100을 만족하면 두 난쟁이의 값을 0으로 바꾸고 break
출력할 때는 0이 아닌 난쟁이들 오름차순으로 출력
 */
public class Main2309 {
	static int[] nanjaeng, tmp, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nanjaeng = new int[9];
		tmp = new int[7];
		ans = new int[7];

		for(int i=0; i<9; i++){
			nanjaeng[i] = sc.nextInt();
		}

		Arrays.sort(nanjaeng);

		comb(0,0);

		for(int i=0; i<7; i++){
			System.out.println(ans[i]);
		}
	}
	private static void comb(int cnt, int start){
		if(cnt==7){
			int sum = 0;
			for(int i=0; i<7; i++){
				sum+=tmp[i];
			}
			if(sum==100) {
				for(int i=0; i<7; i++){
					ans[i] = tmp[i];
				}
			}
			return;
		}

		for(int i=start; i<9; i++){
			tmp[cnt] = nanjaeng[i];
			comb(cnt+1, i+1);
		}
	}
}
