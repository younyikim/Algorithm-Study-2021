package level14_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11054 {
	static int N;
	static int[] dp;
	static int[] dp_down;
	static int[] arr;
	static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	
		
		arr = new int[N + 1];
		dp = new int[N + 1]; 
		dp_down = new int[N + 1]; 

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		arr = {1 5 2 1 4 3 4 5 2 1}
//		증가하는 수열  => dp = {0 1 1 0 2 2 3 4 1 0 }
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

//		 감소하는 수열  => dp_down ={0 4 1 0 3 2 2 2 1 0}
		for(int i = N; i > 0; i--) {
			for (int j = i; j < N; j++) {
				if (arr[i] > arr[j]) {
					dp_down[i] = Math.max(dp_down[i], dp_down[j] + 1);
				}
			}
			MAX = Math.max(dp[i] + dp_down[i], MAX);
		}
		System.out.println(MAX + 1);
	}

}
