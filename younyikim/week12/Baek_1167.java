package level28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1167 {
	
	static class Tree {
		int to, dist;
		
		Tree(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}
	
	static ArrayList<ArrayList<Tree>> list;
	static int[] dist;
	static int V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int node = Integer.parseInt(st.nextToken());
			
			String s;
			
			while(!(s = st.nextToken()).equals("-1")) {
				int to = Integer.parseInt(s);
				int dist = Integer.parseInt(st.nextToken());
				
				list.get(node).add(new Tree(to, dist));
			}
		}
		int longestPath = bfs(1);
		int ansPath = bfs(longestPath);
		System.out.println(dist[ansPath]);
		
	}
	
	public static int bfs(int start) {
		int max = 0;
		
		Queue<Tree> q = new LinkedList<>();
		dist = new int[V + 1];
		boolean [] visited = new boolean[V + 1];
		
		q.offer(new Tree(start, 0));
		
		while(!q.isEmpty()) {
			Tree cur = q.poll();
			visited[cur.to] = true;
			
			for(Tree next : list.get(cur.to)) {
				if(!visited[next.to]) {
					q.offer(next);
					dist[next.to] = dist[cur.to] + next.dist;
					max = Math.max(max, dist[next.to]);
				}
			}
		}
		
		int maxIdx = -1;
		for(int i = 1; i <= V; i++) {
			if(dist[i] == max) {
				maxIdx = i;
				break;
			}
		}
		return maxIdx;
	}
}
