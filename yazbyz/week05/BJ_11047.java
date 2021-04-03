//BaekJoon11047
//author : Hyejin Eom
//20210402

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, K;

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, ",");
		N = Integer.parseInt(st.nextToken());
		if(N < 1 || 10 < N) { return; }
		K = Integer.parseInt(st.nextToken());
		if(K < 1 || 100000000 < K) { return; }

		int[] coin = new int[N];
		for(int i = 0 ; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(greedy(coin));

	}

	public static int greedy(int[] bucket) {
		int result = 0;
		return result;
	}
}
