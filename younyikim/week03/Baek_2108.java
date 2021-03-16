package week03;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Baek_2108 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int check[] = new int[8001];
		int sum = 0;
		List<Integer> list =new ArrayList<>();

		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			check[arr[i] + 4000]++;
			 sum += arr[i];
		}
		StringBuilder sb = new StringBuilder();
		
		// 산술 평균 
		System.out.println((int)Math.round((double)sum/N));
		
		// 중앙값
		Arrays.sort(arr);
		sb.append(arr[N/2]).append('\n');
		
		// 최빈값
		int max = 0;
		for(int i = 0; i < 8001; i++) {            
	          if(check[i] >= max) {
	               max = check[i];
	           }
	    }       
		for(int i = 0; i < 8001; i++) {
	         if(check[i]==max) {
	              list.add(i-4000);
	         }
	    } 
	     if (list.size() == 1)   
	    	 sb.append(list.get(0)).append('\n');
	     else {
	    	  Collections.sort(list);
	    	  sb.append(list.get(1)).append('\n');
	     }
	     
		// 	범위
		sb.append(arr[N - 1] - arr[0]).append('\n');
		
		System.out.println(sb);
	}

}
