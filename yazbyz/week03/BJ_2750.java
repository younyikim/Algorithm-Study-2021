//BaekJoon2750
//author : Hyejin Eom
//20210315

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2750 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 1000) return;

		int[] numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		InsertSort(numbers);

		for(int i = 0; i < N; i++) {
			bw.write(numbers[i] + "\n");
		}

		bw.flush();
		bw.close();
	}

	public static void InsertSort(int[] arr){

		for (int i = 1; i < arr.length; i++) {
			int a = arr[i]; // 기준이 되는 원소
			int b = i - 1; // 비교할 대상

			while (b >= 0 && a < arr[b]) {
				arr[b + 1] = arr[b];
				b--;
			}

			arr[b + 1] = a;
		}
	}
}
