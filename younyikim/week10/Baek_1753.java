package level25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1753 {
	static final int INF = 9999999;
	static int V, E, S;
	static int[] maps;
    static List<List<Node>> list;
 
    static class Node implements Comparable<Node> {
        int index, distance;
 
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
 
        public int compareTo(Node n) {
            return this.distance - n.distance;
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(br.readLine());
		
		maps = new int[V + 1];
		list = new ArrayList<List<Node>>();
		
		list.add(new ArrayList<Node>());
		Arrays.fill(maps, INF);
		for(int i = 1; i <= V; i++) {
            list.add(new ArrayList<Node>());
        }
		
		for(int i = 0; i <E ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken()); 
			int v = Integer.parseInt(st.nextToken()); 
			int w = Integer.parseInt(st.nextToken()); 
			
			list.get(u).add(new Node(v, w));
		}
		dijkstra(list, maps, S);
		
		 for(int i = 1; i <= V; i++) {
	            if(maps[i] == INF)
	               sb.append("INF").append('\n');
	            else
	            	sb.append(maps[i]).append('\n');
	      }
		 System.out.println(sb);
	}
	
	public static void dijkstra(List<List<Node>> list, int[] distance, int start) {
		boolean check[] = new boolean[V + 1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		// 시작 노드 초기화
		distance[start] = 0;
		pq.add(new Node(start, 0));

		while(!pq.isEmpty()) {
			int tmp = pq.poll().index;
			
			if(check[tmp]) {
				continue;
			}
			check[tmp] = true;
			
			 for(Node node : list.get(tmp)) {
				 if(distance[node.index] > distance[tmp] + node.distance) {
					 distance[node.index] = distance[tmp] + node.distance;
					 pq.add(new Node(node.index, distance[node.index]));
				 }
			 }
		}
	
	}
}
