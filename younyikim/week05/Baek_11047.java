package level_15;

import java.io.*;
import java.util.StringTokenizer;
public class Baek_11047 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] value = new int[N];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = N - 1; i >= 0; i--) {
			if (value[i] <= K) {
				cnt += (K / value[i]);
				K = K % value[i];
			}
		}
		System.out.println(cnt);
	}

}
