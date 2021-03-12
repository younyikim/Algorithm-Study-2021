package step10;

import java.util.Scanner;

public class BJ_2447 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		char[][] arr = new char[N][N];
		
		int cnt = 0;
		while(N != 1) {
			cnt++;
			N /= 3;
		}
		
		sc.close();

	}
	
}
