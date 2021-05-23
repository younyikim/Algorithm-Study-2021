package level27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_11779 {
	static ArrayList<Edge>[] graph;
	static int[] dist, preCity;
	static int N, M;
	
	public static class Edge {
		public int end, cost;
		public Edge(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		public int compareTo(Edge e) {
			return cost - e.cost;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		preCity = new int[N + 1];
		
		for(int i  = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Edge(v, w));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		sb.append(dist[end] + "\n");
		
		int cnt = 0;
		Stack<Integer>stack = new Stack<>();
		stack.push(end);
		while(preCity[end] != 0) {
			cnt++;
			stack.push(preCity[end]);
			end = preCity[end];
		}
		sb.append((cnt + 1) + "\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.println(sb);
	}
	public static void dijkstra(int start) {
		Queue<Edge> q = new LinkedList<>();
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start] = 0;
		q.offer(new Edge(start, 0));
		
		while(!q.isEmpty()) {
			Edge e = q.poll();
			int cur = e.end;
			
			for(Edge next : graph[cur]) {
				if(dist[next.end] > dist[cur] + next.cost) {
					dist[next.end] = dist[cur] + next.cost;
					
					// 이전 방문지 저장 
					preCity[next.end] = cur;
					q.offer(new Edge(next.end, dist[next.end]));
				}
			}
		}
	}
}
