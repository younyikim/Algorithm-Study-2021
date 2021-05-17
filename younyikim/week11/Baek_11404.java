package level25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11404 {
	static int INF = 1000000000;
	static int floyd[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		floyd = new int[N + 1][N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				if(i == j) {
					continue;
				}
				floyd[i][j] = INF;
			}
		}
		while(M --> 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			floyd[u][v] = Math.min(floyd[u][v], w);
		}
		
		
		for (int k = 1; k < N + 1; k++) {
			 for(int i = 1; i < N + 1; i++) {
				 for(int j = 1; j < N + 1; j++) {
					 floyd[i][j] = Math.min(floyd[i][k] + floyd[k][j], floyd[i][j]);
				 }
			 }
		 }
		
		 for(int i = 1; i < N + 1; i++) {
			 for(int j = 1; j < N + 1; j++) {
				 if(floyd[i][j] >= INF) {
					 sb.append(0 + " ");
				 }else {
					 sb.append(floyd[i][j] + " ");
				 }
			 }
			 sb.append("\n");
		}
		 System.out.println(sb);
	}
}
