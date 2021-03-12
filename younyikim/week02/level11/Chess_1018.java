package week02.level11;

import java.util.Scanner;
public class Chess_1018 {
	static boolean board[][];
	static int min = 64;
	
	/*답 참고,,
	 * */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		board = new boolean[N][M];
		
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine().trim();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W') {
					board[i][j] = true; 
				} else {
					board[i][j] = false; 
				}
			}
		}
		
		int row = N - 7;
		int cols = M -7;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				check(i, j);
			}
		}
		System.out.println(min);
		
	}
	static void check(int x, int y) {
		boolean color = board[x][y];
		int count = 0;
		
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (board[i][j] != color) count ++;
				color = !color;
			}
			color = !color;
		}
		count = Math.min(count, 64-count);
		min = Math.min(min, count);
	}

}
