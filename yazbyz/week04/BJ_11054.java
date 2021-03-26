//BaekJoon11054
//author : Hyejin Eom
//20210326

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 1000) { return; }

		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (1 > arr[i] || arr[i] > 1000) { return; }
		}

		int index = findMaxIndex(arr);

		int total = bytonic(arr, index);

		System.out.println(total);
	}
	public static int bytonic(int[] arr, int index) {
		int total = arr[index];








		return total;
	}

	public static int findMaxIndex(int[] arr) {
		int max = 0;
		int max_index = 0;

		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				max_index = i;
			}
		}

		return max_index;
	}

}
