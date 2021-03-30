package level14_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_12865 {
	 
	 static int[] W;
	 static int[] V;
	 static int[] dp;
	    
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    W = new int[N + 1];
	    V = new int[N + 1];
	    
	    dp = new int[K + 1];
	    
	    for (int i = 1; i <= N; i++) {
	    	st = new StringTokenizer(br.readLine()," ");
	    	W[i] = Integer.parseInt(st.nextToken());
	    	V[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    for (int i = 1; i <= N; i++) {
	    	for (int j = K; j - W[i] >= 0; j--) {
	    		dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
	    	}
	    }
	    System.out.println(dp[K]);
	}
}
