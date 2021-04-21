package level14_3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Baek_2565 {
	static int arr[][];
	static int dp[];
	static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		arr = new int[N][2];
		dp = new int[N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i][1] > arr[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			MAX = Math.max(dp[i], MAX);
		}
		System.out.println(N - MAX);
	}

}
