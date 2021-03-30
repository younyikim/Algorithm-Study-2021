//BaekJoon9251
//author : Hyejin Eom
//20210328

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr1 = br.readLine().split("");
		String[] arr2 = br.readLine().split("");
		if(arr1.length > 1000 || arr2.length > 1000) { return; }

		int lcs = 0;

		System.out.println(lcs);
	}
}
