package level13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

/* 답안 참고 */

public class Baek_9663 {
	static int N;
	static int check[];
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		check = new int[N];
		nQueen(0);
		System.out.println(cnt);
	}
	
	public static void nQueen(int depth) {
		if (depth == N) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// check[col] = row
			check[depth] = i;
			
			if (isPossible(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	public static boolean isPossible(int col) {
		for (int i = 0 ; i < col; i++) {
			// 세로 확인
			if (check[col] == check[i]) return false;
			// 대각선 확인
			else if(Math.abs(check[col] - check[i]) == Math.abs(col - i)) return false;
		}
		return true;
	}
}
