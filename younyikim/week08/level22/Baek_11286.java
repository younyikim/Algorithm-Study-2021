package level22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	
		
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) ->  {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			/*
			 *  o1 > o2 == 1 :양수
			 *  o1 < o2 == -1 :음수
			 *  
			 *  o1,o2의 절대값이 같다면 실제 숫자를 기준으로 오름차순으로 정렬하고, 
			 *  그렇지 않으면 절대값을 기준으로 오름차순으로 정렬
			 *  
			 *  양수 리턴: 오름차순 / 음수 리턴: 내림차순 / 0 리턴: 변동없음
			 *  
			 *  abs() : 절대값 반환 함수 
			 */
			
			if(abs1 == abs2) {
				return o1 > o2 ? 1 : -1;
			}
			return abs1 - abs2;
		});
		
		while(N --> 0) {
			int X = Integer.parseInt(br.readLine());
			
			if (X == 0 ) {
				if(heap.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					sb.append(heap.poll()).append('\n');
				}
			}
			else {
				heap.offer(X);
			}
		}
		System.out.println(sb);
	}
}
