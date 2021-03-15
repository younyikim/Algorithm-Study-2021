//BaekJoon8393
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_8393 {
	public static void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n;
		int total = 0;

		n = Integer.parseInt(br.readLine());

		for(int i = 1; i <= n; i++)
		{
			total += i;
		}

		System.out.println(total);
	}
}