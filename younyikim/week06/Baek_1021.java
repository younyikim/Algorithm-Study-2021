package level19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		LinkedList<Integer> dq = new LinkedList<Integer>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		int[] find = new int[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			dq.offer(i);
		}
		
		
		for (int i = 0; i < M; i++) {
			int idx = dq.indexOf(find[i]);
			int middle;
			
			// if queue size is even
			if(dq.size() % 2 == 0) {
				middle = dq.size() / 2 - 1;
			}
			// if queue size is odd
			else{
				middle = dq.size() / 2;
			}
			
			// case 2 (rotate left)
			if(idx <= middle) {
				for (int j = 0; j < idx; j++) {
					int tmp = dq.pollFirst();
					dq.offerLast(tmp);
					result++;
				}
			}
			// case 3 (rotate right)
			else {
				for (int j = 0; j < dq.size() - idx; j++) {
					int tmp = dq.pollLast();
					dq.offerFirst(tmp);
					result++;
				}
			}
			dq.pollFirst();
		}
		System.out.println(result);
	}
	
}
