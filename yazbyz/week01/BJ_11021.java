//BaekJoon11021
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_11021 {
	public static void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t;
		int[] array;

		t = Integer.parseInt(br.readLine());

		array = new int[t];

		for(int i = 0; i < t; i++)
		{
			String temp = br.readLine();
			String[] arrTemp = temp.split(" ");

			array[i] = Integer.parseInt(arrTemp[0]) + Integer.parseInt(arrTemp[1]);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0 ; i < t; i++)
		{
			bw.write("Case #" + (i+1) + ": " + array[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
}