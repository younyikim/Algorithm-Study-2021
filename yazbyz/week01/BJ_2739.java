//BaekJoon2739
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2739 {
	public static void main(String []args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n;
		String n_string;

		do {
			n = Integer.parseInt(br.readLine());
		}while(n < 0 || n > 10);

		n_string = Integer.toString(n);

		for(int i = 1; i < 10; i++) {
			System.out.println(n_string + " * " + i + " = " + (n * i));
		}


	}
}