//BaekJoon1427
//author : Hyejin Eom
//20210315

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] temp = br.readLine().split("");
		int[] N = new int[temp.length];
		for(int i = 0; i < N.length; i++) {
			N[i] = Integer.parseInt(temp[i]);
		}

		Arrays.sort(N);
		for(int i = N.length - 1; i >= 0; i--) {
			bw.write(String.valueOf(N[i]));
		}
		bw.flush();
		bw.close();
	}
}
