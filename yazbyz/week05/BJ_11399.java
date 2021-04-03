//BaekJoon11399
//author : Hyejin Eom
//20210402

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;

		N = Integer.parseInt( br.readLine());
		if(N < 1 || 100000 < N) { return; }

		int[] time = new int[N];
		for(int i = 0 ; i < N; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(greedy(time));

	}

	public static int greedy(int[] bucket) {
		int result = 0;
		return result;
	}
}
