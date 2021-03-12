package week02.level11;

import java.util.Scanner;

public class Blackjack_2798 {
	static int result = 0;
	
	static int black(int N, int M, int arr[]) {
		
		for (int i = 0; i < N -2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int temp = arr[i] + arr[j] + arr[k];
					if (temp == M) return M;
					if (temp < M && result < temp) {
						result = temp;
					}
				}
				
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
		arr[i] = in.nextInt();
		}
		System.out.println(black(N, M, arr));
	}

}
