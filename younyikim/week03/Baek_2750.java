package week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Baek_2750 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		int arr[] = new int[size];
		
		 for (int i = 0; i < size; i++){
			 arr[i] = Integer.parseInt(br.readLine());
		    }
		 for(int i = 0; i < size - 1; i++) {
			 for(int j = i + 1; j < size; j++) {
				 if(arr[i] > arr[j]) {
					 int temp = arr[j];
					 	arr[j] = arr[i];
					 	arr[i] = temp;
				 	}
			 	}
			 }

	    for(int val : arr) {
	    	sb.append(val).append('\n');
	    }
	    System.out.println(sb);
	}

}
