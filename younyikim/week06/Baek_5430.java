package level19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 풀이 참조
public class Baek_5430 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st;	
		ArrayDeque<Integer> deque;

		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			String P = br.readLine();
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), "[],");
			
			deque = new ArrayDeque<Integer>();
			
			for(int i = 0; i < N; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			AC(P, deque);
		}
		System.out.println(sb);
	}
	
	public static void AC(String P, ArrayDeque<Integer> deque) {
		boolean isRight = true;
		
		for(char cmd : P.toCharArray()) {
			
			if(cmd == 'R') {
				isRight = !isRight;
				continue;
			} 
			
			if(isRight) {
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			} 
			else {
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}
		makeString(deque, isRight);
	}
	
	public static void makeString(ArrayDeque<Integer> deque, boolean isRight) {
		sb.append('[');	
		if(deque.size() > 0) {
			if(isRight) { // 정방형
				sb.append(deque.pollFirst());
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			else { // 반대방향
				sb.append(deque.pollLast());
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		sb.append(']').append('\n');
	}
}
