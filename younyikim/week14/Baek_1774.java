package level30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point {
	int num;
	double x;
	double y;
	
	Point(int num, double x, double y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
}

class Edge implements Comparable<Edge> {
	int start;
	int end;
	double weight;

	Edge(int start, int end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		if (weight < o.weight) {
			return -1;
		}
		return 1;
	}
}
public class Baek_1774 {
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		Point[] points = new Point[N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			points[i] = new Point(i, x, y);
		}
		
		// 이미 연결되어 있는 간선들을 합집합 연산 
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			union(start, end);
		}
		
		// 모든 통로들 간의 간선과 비용을 edgeList에 넣어둔다. 
		edgeList = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			for(int j = i + 1; j <= N; j++) {
				double weight = distance(points[i], points[j]);
				edgeList.add(new Edge(points[i].num, points[j].num, weight));
			}
		}
		
		// 간선의 비용을 기준으로 오름차순 정렬 
		Collections.sort(edgeList);
		
		double ans = 0;
		
		// 크루스칼 알고리즘
		for(int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			
			// 사이클 제외
			if(find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
		}
		System.out.printf("%.2f", ans);
	}
	
	public static double distance(Point p1, Point p2) {
		// 제곱근과 거듭제곱 연산 
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}
}
