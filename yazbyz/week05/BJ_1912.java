//BaekJoon1912
//author : Hyejin Eom
//20210329

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if(1 > n || n > 100000) { return; }

		int[] arr = new int[n];

		String[] temp = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
			if(arr[i] < -1000 || arr[i] > 1000) { return; }
		}


		int max = 0;

		System.out.println(max);
	}

	public static int sequenceTotal(int[] arr, int start, int end) {
		int max = 0;

		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(max <= sequenceTotal(arr, i, j)) {
					//sequenceTotal(arr);
				}
			}
		}

		return max;
	}
}
