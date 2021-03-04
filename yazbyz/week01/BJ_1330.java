//BaekJoon1330
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1330 {
	public static void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b;

		String s = br.readLine();

		String[] array = s.split(" ");

		a = Integer.parseInt(array[0]);
		b = Integer.parseInt(array[1]);


		if(a > b)
		{
			System.out.println(">");
		} else if(a == b) {
			System.out.println("==");
		} else {
			System.out.println("<");
		}

	}
}