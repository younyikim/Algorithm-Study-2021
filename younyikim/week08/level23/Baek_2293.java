package level23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2293 {
	static int N;
	static int K;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        dp = new int[K + 1];
        dp[0] = 1;

        /*	
         *  주어진 동전의 가치를 사용하여 숫자(K)를 나타내는 방법을  dp에 저장한다.
         *  j = i에서 시작한다.
         *  dp[j] += dp[j - i]를 하고, dp[K]의 값이 우리가 구하고자하는
         *  합이 K원이 되는 경우의 수다.
         *  
         *    0 1 2 3 4 5 6 7 8 9 10
         *  1원  1 1 1 1 1 1 1 1 1 1 1 
		    2원         2 2 3 3 4 4 5 5 6 
       	    5원                   4 5 6 7 8 10
         */
        for (int x = 0; x < N; x++) {
        	int i = Integer.parseInt(br.readLine());
        	System.out.println();
        	for (int j = i; j <= K; j++) {
        			dp[j] += dp[j - i];
        	}
        }
        System.out.println(dp[K]);
	}
}
