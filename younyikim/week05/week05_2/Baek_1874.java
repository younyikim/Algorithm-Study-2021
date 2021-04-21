package level18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_1874 {
	
	static int[] P;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		P = new int[N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			P[i] = Integer.parseInt(st.nextToken());
		}
		
//		¼ö¿­ PÀÇ index
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			stack.push(i);
			sb.append("+").append("\n");
			
			while(!stack.empty()) {
				if(stack.peek() == P[idx]) {
					stack.pop();
					sb.append("-").append("\n");
					idx++;
				}else {
					break;
				}
			}
		}
		
		if(!stack.isEmpty()) {
			System.out.println("NO");
		}else {
			System.out.println(sb);
		}
	}
	
}
