package level14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1003 {
	static StringBuilder sb = new StringBuilder();
	static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			fibo(num);
			sb.append(dp[num][0] + " " + dp[num][1]).append("\n");
		}
		System.out.println(sb);
	}

	public static Integer[] fibo(int n) {
		if (dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
			dp[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
		}
		return dp[n];
	}

}
