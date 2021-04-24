package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1780 {
	static int N;
	static int[][] paper;
	
	static int cnt = 0;
	static int cnt0 = 0;
	static int cnt1 = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Paper(N, 0 , 0);
		System.out.println(cnt);
		System.out.println(cnt0);
		System.out.println(cnt1);
	}
	
	public static void Paper(int n, int x, int y) {
		boolean isSame = true;
		
		
		if (n == 1) {
			if(paper[x][y] == -1) {
				cnt++;
			} else if(paper[x][y] == 0){
				cnt0++;
			} else {
				cnt1++;
			}
			return;
		}
		
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if(paper[x][y] != paper[i][j]) {
					isSame = false;
					break;
				}
			}
		}
		
		if(isSame) {
			if(paper[x][y] == -1) {
				cnt++;
			} else if(paper[x][y] == 0){ 
				cnt0++;
			} else {
				cnt1++;
			}
			return;
		} 
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Paper(n / 3, x + ((n * i) / 3), y + ((n * j) / 3));
			}
		}
	}
}
