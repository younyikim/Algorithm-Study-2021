//BaekJoon2588
//author : Hyejin Eom
//20210228

import java.util.Scanner;

public class BJ_2588 {
	public static void main(String[] args) {
		
		int a, b;

		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();

		System.out.println(a * (b%10));
		System.out.println(a * (b%100/10));
		System.out.println(a * (b/100));
		System.out.println(a * b);

		scan.close();
	}
}
