//BaekJoon10870
//author : Hyejin Eom
//20210311

import java.util.Scanner;

public class BJ_10870 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		while(n < 0 || n > 20)
		{
			n = scan.nextInt();
		}

		System.out.println(fibonacci(n));

	}
	static int fibonacci(int n)
	{
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
