//BaekJoon1018
//author : Hyejin Eom
//20210312

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N, M 입력
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		if(N < 8 || N > 50) return;
		if(M < 8 || M > 50) return;

		// 보드 상태 입력
		char[][] board = new char[N][M];
		for(int i = 0; i < N; i++) {
			String temp2 = br.readLine();
			for(int j = 0; j < M; j++)
				board[i][j] = temp2.charAt(j);
		}



		bw.flush();
		bw.close();
	}

	static void check(char[] A)
	{
		//for(int i = 0; i < A.length; i++)
			//for(int j = 0; j < A[0])
	}
}
