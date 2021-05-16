package level26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2470 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		  int left = 0;
	      int right = N-1;
	      int max = 2000000000;
	      int pick1 = -1, pick2 = -1;
	 
	      while(left < right) {
	          int sum = arr[left] + arr[right];
	          // 두 용액 갱신
	          if(Math.abs(sum) < max) {
	              pick1 = arr[left];
	              pick2 = arr[right];
	              max = Math.abs(sum);
	           }
	 
	          if(sum > 0)
	               right--;
	          else
	               left++;
	      }
	        System.out.println(pick1 + " " + pick2);
	}
}
