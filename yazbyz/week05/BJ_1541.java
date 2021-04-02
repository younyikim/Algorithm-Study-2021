//BaekJoon1541
//author : Hyejin Eom
//20210402

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] formula = br.readLine().split("");

		System.out.println(greedy(formula));

	}

	public static int greedy(String[] bucket) {
		int result = 0;
		return result;
	}
}
