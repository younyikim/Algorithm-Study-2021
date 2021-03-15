//BaekJoon2751
//author :
//reference : https://st-lab.tistory.com/106
//20210315

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 1000000) return;

		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(numbers);

		for(int value : numbers) {
			bw.write(String.valueOf(value) + "\n");
		}

		bw.flush();
		bw.close();
	}

}
