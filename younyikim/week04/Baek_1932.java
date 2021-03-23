package level14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1932 {
	static int[][] tri;
	static Integer[][] dp;
	static int N;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tri = new int[N][N];
		dp = new Integer[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < i + 1; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 삼각형의 아래부분부터 시작해 바텀업 방식으로 탐색 
		for (int i = 0; i < N; i++) {
			dp[N -1][i] = tri[N - 1][i];
		}
		System.out.println(triangle(0,0));
	}
	
	public static int triangle(int depth, int x) {
		if (depth == N - 1) return dp[depth][x];
		
		if (dp[depth][x] == null) {
			dp[depth][x] = Math.max(triangle(depth + 1, x), triangle(depth + 1, x + 1)) + tri[depth][x];
		}
		return dp[depth][x];
	}
}
