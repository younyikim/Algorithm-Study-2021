package step13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650 {

	public static int[] arr;
	public static int N, M;


	public static void dfs(int at, int depth) {
		
		if (depth == M) {
			for (int val : arr) 
				System.out.print(val + " ");
			System.out.println();
			return;
		}
		
		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i+1, depth+1);
		}
	}

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[M];
			
			dfs(1, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
