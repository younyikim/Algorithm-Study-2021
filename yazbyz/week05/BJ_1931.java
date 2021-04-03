//BaekJoon1931
//author : Hyejin Eom
//20210402

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;

		N = Integer.parseInt( br.readLine());
		if(N < 1 || 100000 < N) { return; }

		int[][] meeting = new int[N][2];
		for(int i = 0 ; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			meeting[i][0] = Integer.parseInt(temp[0]);
			meeting[i][1] = Integer.parseInt(temp[1]);
		}

		System.out.println(greedy(meeting));

	}

	public static int greedy(int[][] bucket) {
		int result = 0;
		return result;
	}
}
