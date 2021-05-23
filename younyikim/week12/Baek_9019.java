package level27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_9019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		while(N --> 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			sb = new StringBuilder();
			boolean visit[] = new boolean[10000];
			String[] result = new String[10000];
			Queue<Integer> q = new LinkedList<>();
			
			visit[A] = true;
			q.add(A);
			Arrays.fill(result, "");
			
			while(!q.isEmpty() && !visit[B]) {
				int now = q.poll();
				int D = (now * 2) % 10000;
				int S = (now == 0) ? 9999 : now - 1;
				int L = (now % 1000) * 10 + (now / 1000);
				int R = (now % 10) * 1000 + now / 10;
				
				if(!visit[D]) {
					q.add(D);
					visit[D] = true;
					result[D] = result[now] + "D";
				}
				if(!visit[S]) {
					q.add(S);
					visit[S] = true;
					result[S] = result[now] + "S";
				}
				if(!visit[L]) {
					q.add(L);
					visit[L] = true;
					result[L] = result[now] + "L";
				}
				if(!visit[R]) {
					q.add(R);
					visit[R] = true;
					result[R] = result[now] + "R";
				}
			}
			System.out.println(result[B]);
		}
	}
}
