//BaekJoon10871
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_10871 {
	public static void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n, x;
		int[] array;

		String temp = br.readLine();
		String[] arrTemp = temp.split(" ");

		n = Integer.parseInt(arrTemp[0]);
		x = Integer.parseInt(arrTemp[1]);

		array = new int[n];

		temp = br.readLine();
		arrTemp = temp.split(" ");
		for(int i = 0; i < n; i++)
		{
			array[i] = Integer.parseInt(arrTemp[i]);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0 ; i < n; i++)
		{
			if(array[i] < x)
			{
				bw.write(Integer.toString(array[i]) + " ");
			}
		}
		bw.flush();
		bw.close();
	}
}