package level14_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1912 {
	
	static int[] arr;
	static Integer[] dp;
	static int MAX;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new Integer[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		MAX = arr[0];
		
		solve(N - 1);
		System.out.println(MAX);
	}
	static int solve(int N) {
		if (dp[N] == null) {
			dp[N] = Math.max(solve(N - 1) + arr[N], arr[N]);
			MAX = Math.max(dp[N], MAX);
		}
		return dp[N];
	}

}
