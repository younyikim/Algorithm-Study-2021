package level13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15650 {
	static int arr[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visited = new boolean[N + 1];
		
		dfs(1,N,M,0);
		System.out.println(sb);
	}
	
	static void dfs(int v, int N, int M, int depth) {
		if (depth == M) {
			for (int a: arr)
				sb.append(a +" ");
			sb.append("\n");
			return;
		}
		
		for (int i = v; i <= N; i++) {
			arr[depth] = i;
			dfs(i + 1, N, M, depth + 1);
		}
		return;
	}
}
