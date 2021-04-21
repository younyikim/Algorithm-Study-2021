package level14_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11053 {
	static int N;
	static int[] dp;
	static int[] arr;
	static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	
		
		arr = new int[N + 1];
		dp = new int[N + 1]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr[0] = 0;
		for (int i = 1 ; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
//					System.out.println("dp[" + i +"] : " + dp[i]);
				}
			}
			MAX = Math.max(MAX, dp[i]);
		}
		System.out.println(MAX + 1);
	}
}
