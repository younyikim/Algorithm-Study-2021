package level_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 立辟 规过 老何 曼绊
public class Baek_13305 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] cost = new long[N];
		long[] len = new long[N - 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N - 1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N - 1; i++) {
			if (cost[i] > cost[i - 1]) cost[i] = cost[i - 1];
		}
		long result = 0;
		for (int i = 0; i < N - 1; i++) {
			result += (cost[i] * len[i]);
		}
		System.out.println(result);
	}
}
