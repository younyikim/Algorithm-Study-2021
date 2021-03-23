package level14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_9461 {
	static int[] num;
	static Long[] dp= new Long[101];
	static int N;
	static int result;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		dp = new Long[101];
		
		dp[0] = 0L;
		dp[1] = 1L;
		dp[2] = 1L;
		dp[3] = 1L;
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			num[i] = Integer.parseInt(st.nextToken());
			sb.append(solve(num[i])).append('\n');
		}
		System.out.println(sb);
	}
	static public long solve (int x) {
		if (dp[x] == null) {
			dp[x] = solve(x - 2) + solve(x - 3);
		}
		return dp[x];
	}
	

}
