package week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

public class Baek_2751 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < size; i++)
			list.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(list);
		 for(int val : list) {
		    	sb.append(val).append('\n');
		    }
		    System.out.println(sb);
	}

}
