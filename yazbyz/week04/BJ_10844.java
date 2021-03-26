//BaekJoon10844
//author : Hyejin Eom
//20210325

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 100) { return; }

		System.out.println(makeMaxMin(N));

	}

	public static int makeMaxMin(int size) {
		int total = 0;

		int max_num = 9;
		int min_num = 1;

		for(int i = 1; i < size; i++) {
			max_num += 9 * Math.pow(10, i);
			min_num *= 10;
		}
		int fail = 0;
		for(int i = max_num; i >= min_num; i--) {
			if(checkStairNum(i, size)) {
				total++;
				//System.out.print(i + " ");
			}
			else {
			fail++;}
		}
		//System.out.println("계단수가 아닌수 : " + fail);
		return total;
	}

	public static boolean checkStairNum(int num, int size) {
		int[] split_num = new int[size];

		// 계산하기 좋도록 숫자 준비
		for(int i = size - 1; i >= 0; i--) {
			split_num[i] = num % 10;
			num /= 10;
		}

		// 계단 수인지 확인
		for(int i = 0; i < size - 1; i++) {
			if(Math.abs(split_num[i] - split_num[i+1]) != 1) { // 계단 수가 아니면
				return false;
			}
		}
		return true;
	}
}
