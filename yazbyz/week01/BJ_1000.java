//BaekJoon1000
//author : Hyejin Eom
//20210228

import java.util.Scanner;

public class BJ_1000 {
	public static void main(String[] args) {
		int a, b;

		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();

		System.out.println(a+b);

		/*
		이게 10ms정도 더 빠르다.
		Scanner scan = new Scanner(System.in);
		a = Integer.parseInt(scan.next());
		b = Integer.parseInt(scan.next());

		System.out.println(a+b);
		*/

		scan.close();

	}
}
