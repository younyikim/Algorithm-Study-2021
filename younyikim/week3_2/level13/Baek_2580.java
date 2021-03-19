
package level13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Baek_2580 {
	static int arr[][] = new int[9][9];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 스도쿠 입력
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0,0);
		
	}
	public static void sudoku(int row, int col) {
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}
		
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if (arr[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isPossible(row, col, i)) {
					arr[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			arr[row][col] = 0;
			return;
		}
		sudoku(row, col + 1);
	}
	
	public static boolean isPossible(int row, int col, int value) {
		// 가로 체크
		for (int i = 0 ; i < 9; i++) {
			if (arr[row][i] == value)
				return false;
		}
		// 세로 체크
		for (int i = 0 ; i < 9; i++) {
			if (arr[i][col] == value)
				return false;
		}
		// 3 * 3 박스 체크
		int row_box = (row / 3) * 3;
		int col_box = (col / 3) * 3;
		for (int i = row_box; i < row_box + 3; i++) {
			for (int j = col_box; j < col_box + 3; j++) {
				if (arr[i][j] == value) return false;
			}
		}
		
		return true;
	}
}	
