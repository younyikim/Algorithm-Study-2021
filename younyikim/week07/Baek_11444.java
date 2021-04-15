package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 답안 참고 (????)
public class Baek_11444 {
	
	static long MOD = 1000000007;
	static long[][] arr = { {1, 1}, {1, 0} };
	
	public static void main(String[] arg) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		long ans; 
		
		if(N == 1) {
			ans = 1;
		} else {
			long[][] res = pow(N - 1);
			ans = res[0][0];
		}
		
		System.out.println(ans);
	}
	
	public static long[][] pow(long n) {
		long[][] tmp = new long[2][2];
		
		if(n == 1) {
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					tmp[i][j] = arr[i][j];
				}
			}
			return tmp;
		}
		
		long[][] m;
		m = pow(n / 2);
		
		for(int i = 0; i < 2; i++) {
        	for(int j = 0; j < 2; j++) {
        		for(int k = 0; k < 2; k++) {
        			tmp[i][j] += m[i][k] * m[k][j];
        		}
        		tmp[i][j] %= MOD;
        	}
        }
		
		if(n % 2 == 1) {
			long[][] t = new long[2][2];
			for(int i = 0; i < 2; i++) {
	        	for(int j = 0; j < 2; j++) {
	        		for(int k = 0; k < 2; k++) {
	        			t[i][j] += tmp[i][k] * arr[k][j];
	        		}
	        		t[i][j] %= MOD;
	        	}
	        }
			return t;
		} else {
			return tmp;
		}
	}
}
