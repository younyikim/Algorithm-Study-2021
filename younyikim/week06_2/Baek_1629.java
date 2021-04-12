package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1629 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
       
        System.out.println(power(A % C, B, C));
	}
	
	private static long power(long A, long B, long C) {
		if(B == 1) return A;
		
		long tmp = power(A, B/2, C) % C;
		
		
		//B가 짝수일때, ex) 10 ^ 10 = (10^5)^2
		if(B % 2 == 0) {
			return (tmp * tmp) % C;
		}
		//B가 홀수일때, ex) 10 ^ 11 = (10^5)^2 * 10
		else {
			return (((tmp * tmp) % C) * A) % C;
		}
	}
}
