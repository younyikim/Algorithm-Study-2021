package step13;

import java.util.Scanner;

public class BJ_9963 {
	
	public static int N;
	public static int count = 0;
	public static int[] cols;
	
	public static boolean isPromising(int level) {
		
		for (int i = 0; i < level; i++) {
			if (cols[i] == cols[level])		return false;
			if (Math.abs(level-i) == Math.abs(cols[level] - cols[i]))	return false;
		}
		return true;
	}
	
	public static void nQueen(int level) {
		
		if (level == N)
			count++;
		else {
			for (int i = 0; i < N; i++) {
				cols[level] = i;
				if (isPromising(level)) {
					nQueen(level+1);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		cols = new int[N];
		nQueen(0);
		System.out.println(count);
		
		sc.close();
	}

}
