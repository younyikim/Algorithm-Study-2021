package week02.level11;

import java.util.Scanner;
public class Weight_7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int group[][] = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			group[i][0] = sc.nextInt();
			group[i][1] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			int rank = 1;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (group[i][0] < group[j][0] && group[i][1] < group[j][1]) {
					rank++;
				}
			}
			System.out.print(rank + " ");
		}
	}

}
