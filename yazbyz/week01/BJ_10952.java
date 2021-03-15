//BaekJoon10952
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ_10952 {
	public static void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b;
		ArrayList<Integer> list = new ArrayList<Integer>();

		do {
			String temp = br.readLine();
			String[] arrTemp = temp.split(" ");

			a = Integer.parseInt(arrTemp[0]);
			b = Integer.parseInt(arrTemp[1]);

			list.add(a + b);
		}while(a != 0 && b != 0);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < list.size() - 1; i++)
		{
			bw.write(list.get(i) + "\n");
		}
		bw.flush();
		bw.close();
	}
}