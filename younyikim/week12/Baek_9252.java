package level27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_9252 {
	static char[] arr1;
	static char[] arr2;
	static int [][] dp;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		arr1 = str1.toCharArray();
		arr2 = str2.toCharArray();
		
		dp = new int[ arr1.length + 1][ arr2.length + 1];
		
		for(int i = 1; i <= arr1.length; i++) {
			for(int j = 1; j <= arr2.length; j++) {
				if(arr1[i - 1] == arr2[j - 1]) { 
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		System.out.println(dp[arr1.length][arr2.length]);
		
		int row = arr1.length;
		int col = arr2.length;
		
		while(!(row == 0 || col == 0)) {
            if(arr1[row - 1] == arr2[col - 1]) {
                sb.append(arr1[row - 1]);
                row--; col--;
            }
            else if(dp[row][col] == dp[row - 1][col]) {
                row--;
            }
            else if(dp[row][col] == dp[row][col - 1]) {
                col--;
            }
        }
		
		System.out.println(sb.reverse());
	}
	
}
