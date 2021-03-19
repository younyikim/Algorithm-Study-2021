//BaekJoon15650
//author : Hyejin Eom
//20210318

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15650 {
	public static int[] arr;
	public static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		if (1 > M || M > N || N > 8) { return; }

		arr = new int[M];

		dfs(1, 0);
	}
	public static void dfs(int at, int depth) {
		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}

	// 출처: https://st-lab.tistory.com/115?category=862595 [Stranger's LAB]
}
