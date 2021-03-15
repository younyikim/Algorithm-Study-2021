//BaekJoon2798
//author : Hyejin Eom
//20210312

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N, M 입력
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		if(N < 3 || N > 300000) return;
		if(M < 10 || M > 300000) return;

		// 카드 입력
		temp = br.readLine().split(" ");
		int[] card = new int[N];
		for(int i = 0; i < N; i++)
		{
			card[i] = Integer.parseInt(temp[i]);

			if(card[i] > 100000) return;
		}

		// 뽑을 수 있는 카드 개수
		int pick = 3;


		// 결과 출력
		bw.write(String.valueOf(pick(card, N, M)));

		bw.flush();
		bw.close();
	}

	static int pick(int[] A, int N, int M) {
		int total = 0;

		for (int i = 0; i < N - 2; i++)
			for (int j = i + 1; j < N - 1; j++)
				for (int k = j + 1; k < N; k++) {
					int temp = A[i] + A[j] + A[k];
					if (M == temp)
						return temp;
					if (total < temp && temp < M)
						total = temp;
				}

		return total;
	}
}
