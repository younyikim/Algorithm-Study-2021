//BaekJoon12865
//author : Hyejin Eom
//20210330

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// N, K 입력
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		if(1 > n || n > 100) { return; }

		int k = Integer.parseInt(st.nextToken());
		if(1 > k || k > 100000) { return; }

		// W, V 입력
		int[][] dp = new int[n + 1][k + 1];
		int[] w = new int[n + 1];
		int[] v = new int[n + 1];

		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());

			for(int j = 1; j <= k; j++) {
				dp[i][j] = dp[i - 1][j];
				if(w[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
				}
			}
		}

		// System.out.println();
		// for(int i = 1; i <= n; i++) {
		// 	for (int j = 1; j <= k; j++) {
		// 		System.out.print(dp[i][j] + "\t");
		// 	}
		// 	System.out.println();
		// }

		System.out.print(dp[n][k]);
	}
}
