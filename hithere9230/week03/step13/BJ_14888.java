package step13;

import java.util.Scanner;

public class BJ_14888 {
	private static int[] opArr = new int[4];
	private static int[] numArr;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		numArr = new int[size];
		
		for (int i = 0; i < numArr.length; i++)
			numArr[i] = sc.nextInt();
		
		for (int i = 0; i < opArr.length; i++)
			opArr[i] = sc.nextInt();
		
		dfs(numArr[0], 1);
		
		System.out.println(max);
		System.out.println(min);
		
		sc.close();
	}

	private static void dfs(int num, int index) {

		if (index == numArr.length) { 
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for (int i = 0; i < opArr.length; i++) { 

			if (opArr[i] > 0) {
				
				opArr[i]--;

				if (i == 0) 
					dfs(num + numArr[index], index + 1);
				else if (i == 1) 
					dfs(num - numArr[index], index + 1);
				else if (i == 2) 
					dfs(num * numArr[index], index + 1);
				else 
					dfs(num / numArr[index], index + 1);
				
				opArr[i]++;
			}
		}

	}
}