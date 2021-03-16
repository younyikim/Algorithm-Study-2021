//BaekJoon10989
//author : Hyejin Eom
//20210315

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 10000000) return;

		int[] numbers = new int[N];
		for(int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp > 10000) return;
			numbers[i] = temp;
		}

		Arrays.sort(numbers);

		for(int value : numbers) {
			bw.write(String.valueOf(value) + "\n");
		}

		bw.flush();
		bw.close();
	}
}
