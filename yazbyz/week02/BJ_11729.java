//BaekJoon11729
//author : Hyejin Eom
//20210311

import java.util.Scanner;

public class BJ_11729 {
	public static int move = 0;
	public static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);


		int N = scan.nextInt();
		while(N < 0 || N > 21)
		{
			N = scan.nextInt();
		}

		hanoi_top(N, 1, 2, 3);

		System.out.println(move);
		System.out.println(stringBuilder);

	}

	static void hanoi_top(int N, int from, int temp, int to)
	{
		if(N == 1){
			stringBuilder.append(from + " " + to + "\n");
			move++;
		} else {
			hanoi_top(N - 1, from, to, temp);
			stringBuilder.append(from + " " + to + "\n");
			move++;
			hanoi_top(N - 1, temp, from, to);
		}
	}
}
