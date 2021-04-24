package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1992 {
	
	static int N;
	static int[][] video;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		
		QuadTree(N, 0 , 0);
		System.out.println(sb);
	}
	
	public static void QuadTree(int n, int x, int y) {
		boolean isSame = true;
		
		if (n == 1) {
			if(video[x][y] == 1) {// black => 1
				sb.append("1");
			} else { // white => 0
				sb.append("0");
			}
			return;
		}
		
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if(video[x][y] != video[i][j]) {
					isSame = false;
					break;
				}
			}
		}
		
		if(isSame) {
			if(video[x][y] == 1) {// black => 1
				sb.append("1");
			}
			else { // white => 0
				sb.append("0");
			}
			return;
		} 
		
		sb.append("(");
		QuadTree(n/2, x, y);
		QuadTree(n/2, x, y + n / 2);
		QuadTree(n/2, x + n / 2, y);
		QuadTree(n/2, x + n / 2, y + n / 2);
		sb.append(")");
	}
}
