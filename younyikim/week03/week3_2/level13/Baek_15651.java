package level13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15651 {

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
		
		dfs(0,N,M);
		System.out.println(sb);
	}
	
	static void dfs(int v, int N, int M) {
		if (v == M) {
			for (int a: arr)
				sb.append(a +" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				arr[v] = i;
				dfs(v + 1, N, M);
				visited[i] = false;
			}
			
		}
		return;
	}

}
