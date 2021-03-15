//BaekJoon11651
//author : Hyejin Eom
// reference : https://st-lab.tistory.com/110
//20210315

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_11651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 100000) { return; }

		int[][] location = new int[N][2];
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			location[i][1] = Integer.parseInt(temp[0]);
			location[i][0] = Integer.parseInt(temp[1]);
		}

		Arrays.sort(location, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});

		// 출처: https://st-lab.tistory.com/110 [Stranger's LAB]

		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			sb.append(location[i][1] + " " + location[i][0]).append('\n');
		}
		System.out.println(sb);
	}
}
