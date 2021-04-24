package level13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 답안 참고 */
public class Baek_14889 {
	public static int N;
	public static int[][] S;
	public static int MIN = Integer.MAX_VALUE;
	
	public static boolean visited[];
	public static int arr[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		visited = new boolean[N + 1];
		arr = new int[N / 2];
		
		// S[] 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(MIN);
	}
	
	public static void dfs(int v, int depth) {
		if (depth == N/2) {
			teamScore();
			return;
		}
		for (int i = v; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}	

		
	static void teamScore()	{
		int team_start = 0;
		int team_link = 0;
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] == true && visited[j] == true) {
					team_start += S[i][j];
					team_start += S[j][i];
				} else if (visited[i] == false && visited[j] == false) {
					team_link += S[i][j];
					team_link += S[j][i];
				}
			}
		}
		int result = Math.abs(team_link - team_start);
		
		if (result == 0) {
			System.out.println(result);
			System.exit(0);
		}
		MIN = Math.min(result, MIN);
		
	}
 }
