package week02.level10;

import java.util.Scanner;

public class Fibo_10870 {

	static int fibo (int n) {
		if (n <= 1) return n;
		return fibo(n - 1) + fibo(n - 2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibo(n));
	}

}
