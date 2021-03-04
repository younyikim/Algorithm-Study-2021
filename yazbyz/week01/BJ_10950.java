//BaekJoon10950
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10950 {
	public static void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t;
		int[][] array;

		t = Integer.parseInt(br.readLine());

		array= new int[t][2];

		for(int i = 0; i < t; i++) {
			String temp = br.readLine();
			String[] arrTemp = temp.split(" ");
			array[i][0] = Integer.parseInt(arrTemp[0]);
			array[i][1] = Integer.parseInt(arrTemp[1]);
		}

		for(int i = 0; i < t; i++) {
			System.out.println(array[i][0] + array[i][1]);
		}

	}
}