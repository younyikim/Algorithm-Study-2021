//BaekJoon10872
//author : Hyejin Eom
//20210311
import java.util.Scanner;

public class BJ_10872 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		while(N < 0 || N > 12)
		{
			N = scan.nextInt();
		}

		System.out.println(factorial(N));

	}

	static int factorial(int n)
	{
		if(n == 0)
			return 1;
		return n * factorial(--n);
	}
}
