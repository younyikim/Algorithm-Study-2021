package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10989_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] arr = new int[10001];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())] ++;
		}
		br.close();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i < 10001; i++){
			while(arr[i] > 0){
				sb.append(i).append('\n');
				arr[i]--;
			}
		}
		System.out.println(sb);
	}

}
