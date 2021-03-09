//BaekJoon1110
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_1110 {
	public static void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n, newN;
		int cycle = 0;

		n = Integer.parseInt(br.readLine());

		newN = makeNewNum(n);
		cycle++;

		while(newN != n)
		{
			newN = makeNewNum(newN);
			cycle++;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(cycle + "\n");

		bw.flush();
		bw.close();
	}

	static int makeNewNum(int num) {
		int[] t = new int[2];
		int newNum;
		int temp;

		if(num < 10)
		{
			t[0] = 0;
			t[1] = num;
		} else {
			t[0] = num / 10;
			t[1] = num % 10;
		}

		temp = t[0] + t[1];

		newNum = t[1]*10 + temp%10;

		return newNum;

	}
}