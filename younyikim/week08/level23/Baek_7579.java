package level23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_7579 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int [] memoryArr = new int[N];
        int [] costArr = new int[N];
        int [] dp = new int[100001];
        
        int result = Integer.MAX_VALUE;
        
        st  = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
        	memoryArr[i] = Integer.parseInt(st.nextToken());
        }
        
        st  = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
        	costArr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < N; i++) {
        	int cost = costArr[i];
        	int memory = memoryArr[i];
        	
        	for(int j = 10000; j >= cost; j--) {
        		if(dp[j - cost] != -1) {
        				dp[j] = Math.max(dp[j], dp[j - cost] + memory);
        		}
        		if(dp[j] >= M) {
            		result = Math.min(result, j);
            	}
        	}
       
        }
        System.out.println(result);
	}
	
}
