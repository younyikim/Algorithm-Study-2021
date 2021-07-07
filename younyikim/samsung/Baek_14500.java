package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * DFS(백트래킹) 
 */
public class Baek_14500 {
	private static int n, m, a[][], result;
	private static boolean check[][];
	
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {-1, 1, 0, 0};
    
    private static int ex[][] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    private static int ey[][] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};
    
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new int[n + 1][m + 1];
		check = new boolean[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				check[i][j] = false;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				check[i][j] = true;
				
				dfs(i, j, a[i][j], 1);
				
				/* check를 해제하더라도, length를 통해 재귀를 중단시키기 때문에 
				     수행횟수는 한 점당 4 * 3 * 3 = 36회가 최대이다.*/
				check[i][j] = false;
				
				/*테트로미노의 모양이 'ㅗ' 인 경우*/
				check_shape(i, j);
			}
		}
		System.out.println(result);
	}
	
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static void dfs(int x, int y, int sum_value, int length) {
		if(length >= 4) {
			result = max(result, sum_value);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 지도의 범위 검사
			if(nx < 1 || nx > n|| ny < 1 || ny > m) continue;
			
			// 방문하지 않은 점일 경우
			if(check[nx][ny] == false) {
				
				check[nx][ny] = true;
				
				dfs(nx, ny, sum_value + a[nx][ny], length + 1);
				
				/*
				 * 하나의 테트로미노를 탐색한 뒤, 이곳으로 돌아온다.
				 * 하나의 테트로미노를 대칭, 회전 시키기 위해선 방문한 점을 다시 방문해 dfs를 진행해야한다.
				 * 그래서 한 개를 탐색 후, 나갈 때 체크를 해체한다. 
				 */
				check[nx][ny] = false;
			}
		}
	}
	
	// 테트로미노의 모양이 'ㅗ' 인 경우
	public static void check_shape(int x, int y) {
		for(int i = 0; i < 4; i++) {
			Boolean isOut = false;
			int sum_value = 0;
			
			for(int j = 0; j < 4; j++) {
				int nx = x + ex[i][j];
				int ny = y + ey[i][j];
				
				// 지도 범위 검사
				if(nx < 1 || nx > n || ny < 1 || ny > m) {
                    isOut = true;
                    break;
                } else {
                	sum_value += a[nx][ny];
                }
			}
			
			if(!isOut) {
				result = max(result, sum_value);
			}
		}
	}
}
