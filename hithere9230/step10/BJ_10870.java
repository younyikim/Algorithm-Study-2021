package step10;

import java.util.Scanner;

public class BJ_10870 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		System.out.println(fib(num));
		
		sc.close();

	}

	public static int fib(int num) {
		
		if (num == 0)
			return 0;
		else if (num == 1)
			return 1;
		else
			return (fib(num-1) + fib(num-2));
			
	}
}
