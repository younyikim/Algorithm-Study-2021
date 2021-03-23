package level14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1904 {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		
		dp[0] = 1;
		dp[1] = 2;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 2] + dp[i- 1]) % 15746 ; 
		}
		System.out.println(dp[N -1]);
	}

}
