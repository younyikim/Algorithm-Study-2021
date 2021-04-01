package level_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 답안 참고
public class Baek_1541 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = Integer.MAX_VALUE;
		StringTokenizer substration = new StringTokenizer(br.readLine(), "-");
		
		while(substration.hasMoreTokens()) {
			int tmp = 0;
			
			StringTokenizer addition = new StringTokenizer(substration.nextToken(), "+");
			while(addition.hasMoreTokens()) {
				tmp += Integer.parseInt(addition.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE)sum = tmp;
			else sum -= tmp;

		}
		System.out.println(sum);
	}
}
