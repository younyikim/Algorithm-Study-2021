package step13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649 {

	public static int[] arr;
	public static boolean[] visited;

	public static void dfs (int N, int M, int depth) {

		if (depth == M) {
			for (int val : arr) 
				System.out.print(val + " ");
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(N, M, depth + 1);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			arr = new int[M];
			visited = new boolean[N];
			dfs(N, M, 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//	public static int[] arr;
//	public static boolean[] visited;
//
//	public static void dfs (int N, int M, int depth) {
//
//		if (depth == M) {
//			for (int val : arr) 
//				System.out.print(val + " ");
//			System.out.println();
//			return;
//		}
//
//		for (int i = 0; i < N; i++) {
//			if (!visited[i]) {
//				visited[i] = true;
//				arr[depth] = i + 1;
//				dfs(N, M, depth + 1);
//				visited[i] = false;
//			}
//		}
//
//	}
//
//	public static void main(String[] args) {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		try {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//
//			int N = Integer.parseInt(st.nextToken());
//			int M = Integer.parseInt(st.nextToken());
//
//			arr = new int[N];
//			visited = new boolean[N];
//			dfs(N, M, 0);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//}

