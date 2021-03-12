package step10;

import java.util.Scanner;

public class BJ_11729 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		sb.append((int)((Math.pow(2, num)-1)) + "\n");
		
		hanoi(num, 1, 2, 3);
		
		System.out.println(sb);
		
		sc.close();

	}

	public static void hanoi(int num, int start, int mid, int end) {
		
		if (num == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		else {
			hanoi(num-1, start, end, mid);
			sb.append(start + " " + end + "\n");
			hanoi(num-1, mid, start, end);
		}
	}
}
