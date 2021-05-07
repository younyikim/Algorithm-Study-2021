package level24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1697 {
	
	static int N;
	static int K;
	static int[] check = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) {
			System.out.println(0);
		} else {
			bfs(N);
		}
	}
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		check[n] = 1;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for (int i = 0; i < 3; i++) {
				int next;
				
				//1초후, X + 1로 이동
				if(i == 0) {
					next = x + 1;
				}
				//1초후, X - 1로 이동
				else if(i == 1) {
					next = x - 1;
				}
				//1초후, X * 2로 순간이동
				else {
					next = x * 2;
				}
				
				if(next == K) {
					System.out.println(check[x]);
					return;
				}
				
				if(next >= 0 && next < check.length && check[next] == 0) {
					q.offer(next);
					check[next] = check[x]  + 1;
				}
			}
		}
	}
}
