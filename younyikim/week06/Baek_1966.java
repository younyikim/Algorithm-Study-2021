package level19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 답안 참고 
public class Baek_1966 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
 
			for (int i = 0; i < N; i++) {
				// {index, important}
				q.offer(new int[] { i, Integer.parseInt(st.nextToken())});
			}
			
			int count = 0;
			
			while(!q.isEmpty()) { // loop for one case
				int[] front = q.poll(); // first element
				boolean isMax = true;
				
				for (int i = 0; i < q.size(); i++) {
					
					// 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우 
					if (front[1] < q.get(i)[1]) {
						
						q.offer(front);
						
						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						
						isMax = false;
						break;
					}
				}
				
				// front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
				if(isMax == false) continue;
				
				count++;
				if(front[0] == M) {// 찾고자 하는 문서라면 해당 테스트케이스 종료
					break;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
	
}
