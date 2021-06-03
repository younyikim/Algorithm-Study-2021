package level30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Planet {
	int num;
	int x, y, z;
	public Planet(int num, int x, int y, int z) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class PEdge implements Comparable<PEdge> {
	int start;
	int end;
	int weight;

	PEdge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(PEdge o) {
		return weight - o.weight;
	}

}

public class Baek_2887 {

	static int[] parent;
	static ArrayList<PEdge> PEdgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		Planet[] planets = new Planet[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			planets[i] = new Planet(i, x, y, z);
		}
		
		PEdgeList = new ArrayList<>();
		
		// x,y,z에 대해 각각 정렬하고 각 행성의 번호와 비용을 PEdgeList에 추가
		Arrays.parallelSort(planets, (p1, p2) -> p1.x - p2.x);
		for(int i = 0; i < N - 1; i++) {
			int weight = Math.abs(planets[i].x - planets[i + 1].x);
			PEdgeList.add(new PEdge(planets[i].num, planets[i + 1].num, weight));
		}
		
		Arrays.parallelSort(planets, (p1, p2) -> p1.y - p2.y);
		for(int i = 0; i < N - 1; i++) {
			int weight = Math.abs(planets[i].y - planets[i + 1].y);
			PEdgeList.add(new PEdge(planets[i].num, planets[i + 1].num, weight));
		}
		
		Arrays.parallelSort(planets, (p1, p2) -> p1.z - p2.z);
		for(int i = 0; i < N - 1; i++) {
			int weight = Math.abs(planets[i].z - planets[i + 1].z);
			PEdgeList.add(new PEdge(planets[i].num, planets[i + 1].num, weight));
		}
		
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		Collections.sort(PEdgeList);
		
		// 크루스칼 알고리즘
		int ans = 0;
		for(int i = 0; i < PEdgeList.size(); i++) {
			PEdge PEdge = PEdgeList.get(i);
			
			// 사이클 제외
			if(find(PEdge.start) != find(PEdge.end)) {
				ans += PEdge.weight;
				union(PEdge.start, PEdge.end);
			}
		}
		
		System.out.println(ans);
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
