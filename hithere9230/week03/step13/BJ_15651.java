package step13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15651 {
	
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void dfs (int N, int M, int depth) {
		
		if (depth == M) {
			for (int val : arr)
				sb.append(val + " ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[depth] = i + 1;
			dfs(N, M, depth + 1);
		}
	}

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			arr = new int[M];
			dfs(N, M, 0);
			System.out.print(sb);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
