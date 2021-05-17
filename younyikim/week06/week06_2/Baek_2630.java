package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2630 {
	
	static int N;
	static int[][] color;
	
	static int bCnt = 0;
	static int wCnt = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		color = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(N, 0, 0);
		System.out.println(wCnt);
		System.out.println(bCnt);
	}
	
	public static void solve(int n, int x, int y) {
		boolean isSame = true;
		
		// 색종이가 한 장만 남은 경우
		if(n == 1) {
			if(color[x][y] == 1) {// blue => 1
				bCnt++;
			}
			else { // white => 0
				wCnt++;
			}
			return;
		}
		
		// 색종이의 색이 모두 같은지 확인
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if(color[x][y] != color[i][j]) {
					isSame = false;
					break;
				}
			}
		}
		
		// 색종이의 색이 모두 같은 경우
		if(isSame) {
			if(color[x][y] == 1) {// blue => 1
				bCnt++;
			}
			else { // white => 0
				wCnt++;
			}
			return;
		} 
		
		// 4분할
		solve(n/2, x, y);
		solve(n/2, x, y + n / 2);
		solve(n/2, x + n / 2, y);
		solve(n/2, x + n / 2, y + n / 2);
	}
	
}
