package level27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import level27.Baek_11779.Edge;

public class Baek_11780 {
	static int INF = 1000000000;
	static long floyd[][];
	static int path[][];
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		floyd = new long[N + 1][N + 1];
		path = new int[N + 1][N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				path[i][j] = -1;
				if(i == j) {
					continue;
				}
				floyd[i][j] = INF;
			}
		}
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			floyd[u][v] = Math.min(floyd[u][v], w);
			path[u][v] = u;
		}
		floydAlgorithm();
		print();
	}
	
	static public void floydAlgorithm() {
		for (int k = 1; k < N + 1; k++) {
			 for(int i = 1; i < N + 1; i++) {
				 for(int j = 1; j < N + 1; j++) {
					 if(floyd[i][j] > floyd[i][k] + floyd[k][j]) {
						 floyd[i][j] = Math.min(floyd[i][k] + floyd[k][j], floyd[i][j]);
						 path[i][j] = path[k][j];
					 }
				 }
			 }
		 }
	}

	static public void print() {
		
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
		
		for(int i = 1; i < N + 1; i++) {
			 for(int j = 1; j < N + 1; j++) {
				 // i == j이거나 도시에 도달할 수 없는 경우 0 출력 
				 if(path[i][j] == -1) {
					 sb.append("0\n");
				 }
				 // 그 외의 경우 
				 else {
					 // 경로 역추적 
					 Stack<Integer> route = new Stack<Integer>();
					 int pre = j;
					 route.push(j);
					 
					 while(i != path[i][pre]) {
						 pre = path[i][pre];
						 route.push(pre);
					 }
					 
					 // 도시의 총 개수 
					 sb.append(route.size() + 1 + " ");
					 
					 // 경로상의 도시 출력 
					 sb.append(i + " ");
					 while(!route.isEmpty()) {
						 sb.append(route.pop() + " ");
					 }
					 sb.append("\n");
				 }
			 }
		}
		System.out.println(sb);
	}
}
