package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15684 {

	public static int n, m, h, answer;
	public static int[][] map;
	public static boolean isFinish = false;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h + 1][n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 1;
			map[x][y + 1] = 2;
		}
		
		/*
		 * 정답은 항상 3보다 작은 값이기 때문에, 추가해야 하는 선은 3개까지만 확인한다.
		 */
		for(int i = 0; i <= 3; i++) {
			answer = i;
			DFS(1, 0);
			
			if(isFinish) break;
		}
		
		System.out.println((isFinish) ? answer : -1);
	}
	
	public static void DFS(int x, int depth) {
		if(isFinish) return;
		
		if(answer == depth) {
			if(check()) {
				isFinish = true;
			}
			return;
		}
		
		for(int i = x; i < h + 1; i++) {
			for(int j = 1; j < n; j++) {
				if(map[i][j] == 0 && map[i][j + 1] == 0) {
					// 사다리에 가로선 추가
					map[i][j] = 1;
					map[i][j + 1] = 2;
					
					DFS(i, depth + 1);
					map[i][j] = map[i][j + 1] = 0;
				}
			}
		}
	}
	
	public static boolean check() {
		for(int i = 1; i <= n; i++) {
			
			int x = 1, y = i;
			
			for(int j = 0; j < h; j++) {
				
				// 세로선 사이에 가로선이 존재하는 경우
				if(map[x][y] == 1) y++; 
				else if(map[x][y] == 2) y--;
				
				// 가로선이 존재하지 않는 경우, 아래로 내려감.
				x++;
			}
			
			// i번째에서 시작해서 i번째에서 끝나지 않는 경우  false
			if(y != i) return false;
		}
		return true;
	}
}
