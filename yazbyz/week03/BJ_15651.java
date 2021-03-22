//BaekJoon15651
//author : Hyejin Eom
//20210318

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15651 {
	public static int[] arr;
	public static int M, N;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		if (1 > M || M > N || N > 7) { return; }

		arr = new int[M];

		dfs(0);

		System.out.print(sb);
	}
	public static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			dfs(depth + 1);
		}
	}

	// 출처: https://st-lab.tistory.com/115?category=862595 [Stranger's LAB]
}
