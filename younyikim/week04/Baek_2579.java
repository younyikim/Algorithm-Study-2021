package level14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2579 {
	static int[] Score;
	static Integer[] dp;
	static int N;
	
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		Score = new int[N + 1];
		dp = new Integer[N + 1];
		
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Score[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = Score[0];
		dp[1] = Score[1];
		if (N >= 2)
			dp[2] = Score[1] + Score[2];
		
		System.out.println(solve(N));
	}
	
	static int solve(int x) {
		if(dp[x] == null) {
			dp[x] = Math.max(solve(x - 2), solve(x -3) + Score[x -1]) + Score[x];
		}
		return dp[x];
	}
	

}
