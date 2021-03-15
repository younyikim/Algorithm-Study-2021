package week02.level11;

import java.io.*;
public class Movie_1436 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 0;
		
		while(N > 0) {
			num++;
			String str = Integer.toString(num);
			if(str.contains("666")) {
				N--;
			}
		}
		System.out.println(num);
		
//		int count = 0;
//		int result = 0;
//		int i = 666;
//		int j = 1;
//		int temp = 0;
//		
//		while(count != N) {
//			if (i % 1000 == 666) {
//				result = i;
//				count++;
//				i++;
//				continue;
//			}
//			
//			int pow = (int)Math.pow(10, j);
//			temp = i;
//			while (temp > 666) {
//				temp = i / pow;
//				if (temp % 1000 == 666) {
//					result = i;
//					count++;
//				}
//				pow = (int)Math.pow(10, j);
//			}
//			if(count == N) break;
//			i++;
//
//		}
//		System.out.println(result);
	}

}
