package level23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1520 {
	
	static int M;
	static int N;
	static int[][] map;
	static int[][] dp;
	
	static int[] nx = { -1, 0, 1, 0 };
	static int[] ny = { 0, 1, 0, -1 }; // 위쪽 오른쪽 아래쪽 왼쪽
	
	/*
	 * 		   (x-1,y)
	 * (x, y-1) [x,y] (x, y+1)
	 * 		   (x+1,y)
	 * 
	 *  X = {위, 오른쪽, 아래, 왼쪽} = {-1, 0, 1, 0}
	 */
	
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        dp = new int[M][N];
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		dp[i][j] = -1;
        	}
        }      
        System.out.println(dfs(0,0));
	}
	
	public static int dfs(int x, int y) {
		if (x == M - 1 && y == N - 1) {
			return 1;
		}
		
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		
		for(int i = 0; i < 4; i++) {
			// 위 오른쪽 아래 왼쪽 돌아가며 탐색 
			int tmpX = x + nx[i];
			int tmpY = y + ny[i];
			
			if(tmpX < M && tmpY < N && tmpX >= 0 && tmpY >= 0) {
				if(map[x][y] > map[tmpX][tmpY]) { // 아래로 가는 경우 
					dp[x][y] += dfs(tmpX, tmpY);
				}
			}
		}
		
		return dp[x][y];
	}
}
