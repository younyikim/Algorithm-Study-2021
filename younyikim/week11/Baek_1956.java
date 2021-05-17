package level25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import level25.Baek_11657.Edge;

public class Baek_1956 {
	
	static int INF = 400 * 10000;
	static int floyd[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N  = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		floyd = new int[N + 1][N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			Arrays.fill(floyd[i], INF);
		}
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			floyd[u][v] = w;
		}
		
		// 플로이드 와샬
		for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                	floyd[i][j] = Math.min(floyd[i][k] + floyd[k][j], floyd[i][j]);
                }
            }
        }
		
		int min = INF;
		for(int i = 1 ; i <= N; i++) {
			min = Math.min(floyd[i][i], min);
        }
		
		if(min >= INF) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		} 
	}
	
	
}
