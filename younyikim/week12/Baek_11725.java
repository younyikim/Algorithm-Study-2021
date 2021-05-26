package level28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_11725 {
	
	static ArrayList<Integer>[] list;
	static int [] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[v].add(e);
			list[e].add(v);
		}
		
		parent = new int[N + 1];
		dfs(1, 0);
		
		for(int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
	
	private static void dfs(int s, int p) {
		parent[s] = p;
		for(int item : list[s]) {
			if(item != p) {
				dfs(item, s);
			}
		}
	}
	
}
