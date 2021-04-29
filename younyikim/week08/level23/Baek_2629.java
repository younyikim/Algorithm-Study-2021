package level23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2629 {
	
	static int[] W;
	static int N;
	static boolean [][] dp;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        W = new int[N];
        
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
        	W[i] = Integer.parseInt(st.nextToken());
        }
        
        int K = Integer.parseInt(br.readLine());
        int[] Ball = new int[K];
        
        st  = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
        	Ball[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new boolean[N + 1][55001]; // 추의 최대 무게 (30개 * 500g) + 구슬의 최대 무게(40,000g)
        
        solve(0,0);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
        	if(dp[N][Ball[i]]) {
        		sb.append('Y').append(' ');
        		continue;
        	} 
        	sb.append('N').append(' ');
        }
        System.out.println(sb);
	}
	
	public static void solve(int cnt, int weight) {
		if(dp[cnt][weight]) {
			return;
		}
		
		dp[cnt][weight] = true;
		
		if (cnt == N) {
			return;
		}

		/*
		 * 예) 1g,4g 추를 사용하여 구할 수 있는 구슬의 무게
		 * 1) 추 2개를 더한 1g + 5g = 6g 구슬
		 * 2) 추 1개를 사용한 1g or 5g 구슬
		 * 3) 양팔 저울의 다른 팔에 하나 씩 추를 놓는 경우, 4g의 구슬
		 */
		
		// 1)
		solve(cnt + 1, weight + W[cnt]);
		// 2)
		solve(cnt + 1, weight);
		// 3)
		solve(cnt + 1, Math.abs(weight - W[cnt]));
	}
}
