//BaekJoon7568
//author : Hyejin Eom
//20210312

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력
		int N = Integer.parseInt(br.readLine());
		if(2 > N || N > 50) return;

		int[][] data = new int[N][2];
		for(int i = 0; i < N; i++)
		{
			String[] temp = br.readLine().split(" ");
			data[i][0] = Integer.parseInt(temp[0]);
			data[i][1] = Integer.parseInt(temp[1]);

			if(10 > data[i][0] || data[i][0] > 200) return;
			if(10 > data[i][1] || data[i][1] > 200) return;
		}
		// 순위 생성
		int[] rank = makeRank(data);

		// 출력
		for(int i = 0; i < N; i++)
			bw.write(rank[i] + " ");

		bw.flush();
		bw.close();
	}

	static int[] makeRank(int[][] data)
	{
		int[] result = new int[data.length];

		for (int i = 0; i < data.length; i++) {
			int rank = 1;
			for (int j = 0; j < data.length; j++) {
				if (i != j) {
					if (data[i][0] < data[j][0] && data[i][1] < data[j][1]) {
						rank++;
					}
					result[i] = rank;
				}
			}
		}
		return result;
	}
}
