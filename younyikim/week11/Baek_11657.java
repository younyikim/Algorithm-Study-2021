package level25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11657 {
	
	public static class Edge {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Edge e[] = new Edge[M];
			
			long dist[] = new long[N + 1];
			for(int i = 1; i <= N; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				e[i] = new Edge(u, v, w);
			}
			
			// 시작점은 1번 도시
			dist[1] = 0;
			
			for(int i = 0; i < N -1; i++) {
				for(int j = 0; j < M; j++) {
					int u = e[j].u;
					int v = e[j].v;
					int w = e[j].w;
					
					if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
						dist[v] = dist[u] + w;
					}
				}
			}
			
			boolean nCycleCheck = false;
			for(int j = 0; j < M; j++) {
				int u = e[j].u;
				int v = e[j].v;
				int w = e[j].w;
				
				if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
					nCycleCheck = true;
				}
			}
			
			if(nCycleCheck) {
				System.out.println("-1");
			} else {
				for(int i = 2; i <= N; i++) {
					if(dist[i] == Integer.MAX_VALUE) {
						System.out.println("-1");
					} else {
						System.out.println(dist[i]);
					}
				}
			}

	}
}
