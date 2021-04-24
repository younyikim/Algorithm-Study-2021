package level13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14888 {
	public static int N;
	public static int[] op = new int[4]; 
	public static int[] number;
	public static int MAX = Integer.MIN_VALUE;
	public static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		
		// 숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(number[0], 1);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	public static void dfs(int num, int depth) {
		if (depth == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		
		for (int i = 0 ; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				
				switch (i) {
				case 0 : dfs(num + number[depth], depth + 1); break;
				case 1 : dfs(num - number[depth], depth + 1); break;
				case 2 : dfs(num * number[depth], depth + 1); break;
				case 3 : dfs(num / number[depth], depth + 1); break;
				}
				
				op[i]++;
			}
		}
	}
}
