package level22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_11279 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());
			
			// X가 0인 경우, pop()
			if (X == 0 ) {
				if(heap.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					sb.append(heap.poll() * -1).append('\n');
				}
			}
			// X가 자연수인 경우, push() 
			else {
				heap.offer(X * -1);
			}
		}
		System.out.println(sb);
	}
	
	

}	

