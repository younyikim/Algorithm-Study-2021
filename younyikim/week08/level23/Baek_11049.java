package level23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11049 {
	static int N;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        map = new int[N][2];
        dp = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	map[i][0] = Integer.parseInt(st.nextToken());
        	map[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		if(i == j) {
        			dp[i][j] = 0;
        		} else {
        			dp[i][j] = Integer.MAX_VALUE;
        		}
        	}
        }
        
        // dp의 대각선 절반만 탐색 
        for (int c = 1; c < N; c++) {
        	for (int i = 0; i + c < N; i++) {
        		solve(i, i + c);
        	}
        }
        System.out.println(dp[0][N - 1]);
	}
	/*
	 * A~i번, i~B번까지 곱하는 연산은,
	 * [A~i]번까지 연산의 수 + [i + 1, B]번까지의 연산수 + (A * i * B)
	 * 
	 * ex) N = 4, A(5,3), B(3, 2), C(2, 6), D(6, 3)가 있다고 하자.
	 * 
	 *	dp[1][3]을 생각해보자. dp[1][3]은 B*D의 곱셈을 하는 것이기 때문에
	 *	(B*C)*D or B(C*D) 두가지 경우가 있고, 각 경우에 + 곱하는데 드는 비용 중 최소 값이 dp[1][3]의 정답이다.
	 *  (B*C)D => dp[1][2] + dp[3][3] + (map[1][0]*map[2][1]*map[3][1])
	 *  B(C*D) => dp[1][1] + dp[2][3] + (map[1][0]*map[1][1]*map[3][1])
	 *  
	 *  이를 점화식으로 표현하면,
	 *  dp[start][i] + dp[i + 1][end] + (map[start][0]*map[i][1]*map[end][1])
	 *  
	 *  
	 *  map[start][0]*map[i][1]*map[end][1] 은
	 *  예를 들어 (BC)D = (3*6) * D = (3*6) * (6*3) = 3*6*3
	 */
	public static void solve(int start, int end) {
		for (int i = start; i < end; i++) {
			int cost = dp[start][i] + dp[i + 1][end] + (map[start][0] * map[i][1] * map[end][1]);
			dp[start][end] = Math.min(dp[start][end], cost);
		}
	}
	
}	
