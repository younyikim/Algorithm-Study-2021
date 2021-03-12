//BaekJoon2231
//author : Hyejin Eom
//20210312

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N 입력
		int N = Integer.parseInt(br.readLine());
		if(N < 1 || N > 1000000) return;

		// 생성자 생성
		int M = findM(N);

		// 결과 출력
		bw.write(String.valueOf(M));

		bw.flush();
		bw.close();
	}
	static int findM(int n)
	{
		int result = 0;
		// n 자리수
		int n_size = String.valueOf(n).length();
		// 최솟값
		int origin = n - (9 * n_size);

		for(int i = origin; i < n; i++)
		{
			int temp = i;

			int sum = i;
			while(temp > 0)
			{
				sum += temp % 10;
				temp /= 10;
			}

			if(sum == n) {
				result = i;
				break;
			}

		}
		return result;
	}
}