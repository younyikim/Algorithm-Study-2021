package week02.level10;

import java.util.Scanner;

public class Factorial_10872 {

	static int factorial(int n) {
		if (n == 0) return 1;
		return n * factorial(n - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(n));
	}
}
