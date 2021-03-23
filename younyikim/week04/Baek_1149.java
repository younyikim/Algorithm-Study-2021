package level14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1149 {
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][3];
		dp = new int[N][3];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		System.out.println(Math.min(solve(N-1, 0), Math.min(solve(N-1, 1), solve(N-1, 2))));
	}
	
	public static int solve(int idx, int color) {
		if (dp[idx][color] == 0) {
			if (color == 0) { //RED
				dp[idx][0] = Math.min(solve(idx - 1, 1), solve(idx - 1, 2)) + arr[idx][0];
			} else if(color == 1) { //GREEN
				dp[idx][1] = Math.min(solve(idx - 1, 0), solve(idx - 1, 2)) + arr[idx][1];
			} else { //BLUE
				dp[idx][2] = Math.min(solve(idx - 1, 0), solve(idx - 1, 1)) + arr[idx][2];
			}
		}
		return dp[idx][color];
	}

}
