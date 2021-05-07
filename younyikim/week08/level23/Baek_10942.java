package level23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10942 {
	static  int [] A;
	static boolean[][] dp;

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        dp = new boolean[N + 1][N + 1];
        
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= N; i++) {
        	 for(int j = 1; j <= N; j++) {
        		 dp[i][j] = false;
        	 }
        }
        
        palindrome(N);
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	
        	if(dp[s][e]) {
        		sb.append(1).append('\n');
        	} else {
        		sb.append(0).append('\n');
        	}
        }
        System.out.println(sb);
	}
	
	public static void palindrome(int n) {
		// 한자리 숫자인 경우 항상 true
		for (int i = 1; i <= n; i++) {
			dp[i][i] = true;
		}
		
		// 두자리 숫자인 경우, 두 숫자가 같을 때 true
		for (int i = 1; i < n; i++) {
			if(A[i] == A[i + 1]) {
				dp[i][i + 1] = true;
			}
		}
		
		// 세자리수 
		for (int i = 2; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				if(A[j] == A[i + j] && dp[j + 1][j + i - 1]) {
					dp[j][j + i] = true;
				}
			}
		}
	}
}
