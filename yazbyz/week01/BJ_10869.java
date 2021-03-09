//BaekJoon10869
//author : Hyejin Eom
//20210228

import java.util.Scanner;

public class BJ_10869 {
	public static void main(String[] args) {
		
		int a, b;

		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();

		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);

		scan.close();
	}
}
