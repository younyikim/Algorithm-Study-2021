package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11401 {
	 public static void main(String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	        int n = Integer.parseInt(st.nextToken());
	        int k = Integer.parseInt(st.nextToken());
	        
	        long p = 1000000007;
	        
	        long[] f = new long[n + 1];
	        f[0] = 1;
	        f[1] = 1;
	        for(int i = 2; i <= n; i ++) {
	        	f[i] = (f[i - 1] * i) % p;
	        }
	        
	        long a = f[n]; 						// a : n!
	        long b = (f[k] * f[n - k]) %p;		// b : k!*(n-k)!
	        
	        long e = p - 2;		// Áö¼ö( exponent )
	        long b_pow_e = 1;   // bÀÇ e Á¦°ö ( pow ) 
	        while(e > 0) {
	        	if( e % 2 == 1 ) 
					b_pow_e = ( b_pow_e * b ) % p;	// b_pow_e *= b;  b_pow_e %= p;
	            b = ( b * b ) % p;
				e /= 2;
	        }
	        
	        System.out.println( ( ( a % p ) * ( b_pow_e % p ) ) % p );
	 }
}
