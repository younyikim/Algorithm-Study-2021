//BaekJoon2156
//author : Hyejin Eom
//20210325

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 10000) { return; }

		int[] wine = new int[N];
		for(int i = 0; i < N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		// 최댓값
		int max = 0;

		if(N == 1) { // 와인잔이 한 개
			max = wine[0];
		} else if(N == 2) { // 와인잔이 두 개
			max = wine[0] + wine[1];
		} else { // 와인잔 세 개 이상
			for (int i = 0; i < N; i++) {
				int rslt = checkSide(wine, i);
				if (max < rslt) {
					max = rslt;
				}
			}
		}

		// 결과
		System.out.println(max);

	}
	public static int checkSide(int[] arr, int index) {
		int total = arr[index];

		return total;
	}

}
