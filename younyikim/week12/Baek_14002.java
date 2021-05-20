package level27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_14002 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N + 1];
		int [] dp = new int[N + 1];
		int result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken()); 
			arr[i] = num;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
					result = Math.max(dp[i], result);
				}
			}
		}
		sb.append(result + "\n");
		
		int value = result;
		Stack<Integer> stack = new Stack<>();
		
		for(int i = N; i >= 1; i--) {
			if(value == dp[i]) {
				stack.push(arr[i]);
				value --;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.println(sb);
		
	}
}
