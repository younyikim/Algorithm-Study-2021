//BaekJoon11053
//author : Hyejin Eom
//20210326

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 1000) { return; }

		String[] arr_temp = br.readLine().split(" ");
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(arr_temp[i]);
			if (1 > arr[i] || arr[i] > 1000) { return; }
		}

		int total = 0;
		for(int i = 0; i < N; i++) {
			if(total > N - 1 -i) {
				break;
			}

			int temp = longgestArray(arr, i);
			if(total < temp) {
				total = temp;
			}
		}

		System.out.println(total);
	}
	public static int longgestArray(int[] arr, int start) {
		int total = 1;
		int previous = arr[start];

		for(int i = start ; i <= arr.length - 1; i++) {

			if(previous < arr[i]) {
				total++;
				previous = arr[i];
			}
		}

		return total;
	}

}
