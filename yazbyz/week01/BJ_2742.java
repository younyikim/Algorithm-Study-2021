//BaekJoon2742
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2742 {
	public static void main(String []args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n;

		n = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i = n; i >= 1; i--)
		{
			bw.write(i + "\n");
		}

		bw.flush();
		bw.close();
	}

}