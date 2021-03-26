package level14_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2156 {
	static int N;
	static int[] dp;
	static int arr[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		if(N > 1) dp[2] = arr[1] + arr[2];
		
		for (int i = 3; i <= N; i++) {
//			n-1번째 잔을 마심 -> n-3 선택 가능 / n-1번째 마시지 않음 -> n-2 선택 가능
			dp[i] = Math.max(dp[i - 3] + arr[i] + arr[i - 1] , dp[i - 2] + arr[i]);
			
//			항상 마지막잔 마셔야하는 것X + 연속으로 2잔이상 마시지 않을 수 있음.
			dp[i] = Math.max(dp[i - 1], dp[i]);
		}
		System.out.println(dp[N]);
	}
}
